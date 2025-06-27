package com.example;
import com.example.User;
import com.example.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    public UserServiceTest() {
        MockitoAnnotations.openMocks(this); 
    }
    @Test
    public void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setName("Gopika");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        User result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals("Gopika", result.getName());
        assertEquals(1L, result.getId());
    }
    @Test
    public void testGetUserById_NotFound() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());
        User result = userService.getUserById(2L);
        assertNull(result);
    }
}