package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.nio.charset.StandardCharsets;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String base64Credentials = authHeader.substring("Basic ".length());

            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String[] credentials = new String(decodedBytes, StandardCharsets.UTF_8).split(":", 2);

            if (credentials.length == 2) {
                String username = credentials[0];
                String password = credentials[1];

                if ((username.equals("user") || username.equals("admin")) && password.equals("pwd")) {
                    String token = jwtUtil.generateToken(username);
                    return ResponseEntity.ok("{\"token\":\"" + token + "\"}");
                }
            }
        }

        return ResponseEntity.status(401).body("{\"error\":\"Unauthorized\"}");
    }
}