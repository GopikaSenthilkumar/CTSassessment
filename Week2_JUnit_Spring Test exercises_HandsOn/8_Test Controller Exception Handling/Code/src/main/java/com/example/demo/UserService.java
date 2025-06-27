package com.example.demo;
import java.util.*;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private static final Map<Long, User> userRepo = new HashMap<>();
    static {
        userRepo.put(1L, new User(1L, "Gopika"));
        userRepo.put(2L, new User(2L, "Senthilkumar"));
    }
    public User getUserById(Long id) {
        if (!userRepo.containsKey(id)) {
            throw new NoSuchElementException("User not found");
        }
        return userRepo.get(id);
    }
}
