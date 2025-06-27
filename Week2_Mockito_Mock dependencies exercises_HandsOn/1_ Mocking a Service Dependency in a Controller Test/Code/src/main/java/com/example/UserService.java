package com.example;
import com.example.User;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    public User getUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Default User");
        return user;
    }
}