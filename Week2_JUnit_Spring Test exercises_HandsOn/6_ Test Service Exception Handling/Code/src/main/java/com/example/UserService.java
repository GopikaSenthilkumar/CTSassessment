package com.example;
import org.springframework.stereotype.Service;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import java.util.HashMap;
import java.util.Map;
@Service
public class UserService {
    private final Map<Long, User> userStore = new HashMap<>();
    public User getUserById(Long id) {
        if (!userStore.containsKey(id)) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
        return userStore.get(id);
    }
}
