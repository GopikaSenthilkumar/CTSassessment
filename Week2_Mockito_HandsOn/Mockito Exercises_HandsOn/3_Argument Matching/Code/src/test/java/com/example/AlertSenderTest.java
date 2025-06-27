package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
class AlertSenderTest {
	@Test
	public void testSendCalledWithCorrectArguments() {
        NotificationService mockService = mock(NotificationService.class);
        AlertSender sender = new AlertSender(mockService);
        sender.alertAdmin();
        verify(mockService).send(eq("agopikasenthilkumar@gmail.com"), contains("Server"));
    }
}