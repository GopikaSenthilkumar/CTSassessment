package com.example;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    public User saveUser(User user) {
        user.setId(1L);
        return user;
    }
}