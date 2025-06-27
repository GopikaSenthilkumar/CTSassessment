package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class MyServiceTest {
    @Test
    void shouldReturnMockedDataFromApi() {
        ExternalAPI mockApi = mock(ExternalAPI.class);
        when(mockApi.getData()).thenReturn("Sample Mock Response");
        MyService service = new MyService(mockApi);
        String output = service.fetchData();
        assertEquals("Sample Mock Response", output);
    }
}
