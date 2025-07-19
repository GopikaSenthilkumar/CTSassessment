package com.cognizant.jwt_auth.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cognizant.jwt_auth.util.JwtTokenProvider;
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/token")
    public String getToken(@RequestParam String username) {
        return jwtTokenProvider.createToken(username);
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "You accessed a secure endpoint!";
    }
}