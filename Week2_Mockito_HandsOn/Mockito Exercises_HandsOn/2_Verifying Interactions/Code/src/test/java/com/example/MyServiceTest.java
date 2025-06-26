package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
public class MyServiceTest {
    @Test
    public void shouldVerifyFetchMessageCalledOnce() {
        ExternalAPI mockApi = mock(ExternalAPI.class);
        when(mockApi.fetchMessage()).thenReturn("Hello Gopika from API");
        MyService service = new MyService(mockApi);
        service.retrieveMessage();
        verify(mockApi, times(1)).fetchMessage();
    }
}
