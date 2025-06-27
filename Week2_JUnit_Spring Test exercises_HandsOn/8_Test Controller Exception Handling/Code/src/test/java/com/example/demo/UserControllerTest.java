package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.NoSuchElementException;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @Test
    void testUserNotFoundShouldReturn404() throws Exception {
        Long userId = 999L;
        when(userService.getUserById(userId)).thenThrow(new NoSuchElementException());

        mockMvc.perform(get("/users/" + userId))
               .andExpect(status().isNotFound())
               .andExpect(content().string("User not found"));
    }
    @Test
    void testUserFoundShouldReturn200() throws Exception {
        Long userId = 1L;
        User user = new User(userId, "Gopika");
        when(userService.getUserById(userId)).thenReturn(user);
        mockMvc.perform(get("/users/" + userId))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("Gopika"));
    }
}
