package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UserServiceTest {
    @Test
    public void testGetUserById_UserNotFound_ThrowsException() {
        UserService userService = new UserService();
        Long missingUserId = 99L;

        UserNotFoundException exception = assertThrows(
            UserNotFoundException.class,
            () -> userService.getUserById(missingUserId)
        );
        assertEquals("User with ID 99 not found", exception.getMessage());
    }
}