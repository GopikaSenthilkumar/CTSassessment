package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class SecurityManagerTest {
    @Test
    public void testLogAccessThrowsException() {
        AuditService mockAudit = mock(AuditService.class);
        doThrow(new RuntimeException("Access log failed"))
            .when(mockAudit)
            .logAccess("user123");
        SecurityManager manager = new SecurityManager(mockAudit);
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            manager.checkAccess("user123");
        });
        assertEquals("Access log failed", thrown.getMessage());
        verify(mockAudit).logAccess("user123");
    }
}
