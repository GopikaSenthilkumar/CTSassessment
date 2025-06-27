package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
public class UserServiceTest {
    @Test
    public void testNotificationIsSentAfterUserRegistration() {
        NotificationService mockNotification = mock(NotificationService.class);
        UserService userService = new UserService(mockNotification);
        userService.registerUser("Gopika");
        verify(mockNotification).sendNotification("User Gopika registered");
    }
}
