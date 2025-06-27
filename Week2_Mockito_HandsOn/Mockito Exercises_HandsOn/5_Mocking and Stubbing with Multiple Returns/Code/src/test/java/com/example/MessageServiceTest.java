package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class MessageServiceTest {
    @Test
    public void testMultipleReturnsFromExternalApi() {
        ExternalAPI mockApi = mock(ExternalAPI.class);
        when(mockApi.getNextMessage())
            .thenReturn("Hello")
            .thenReturn("Gopika");
        MessageService service = new MessageService(mockApi);
        String result = service.fetchTwoMessages();
        assertEquals("Hello | Gopika", result);
        verify(mockApi, times(2)).getNextMessage();
    }
}