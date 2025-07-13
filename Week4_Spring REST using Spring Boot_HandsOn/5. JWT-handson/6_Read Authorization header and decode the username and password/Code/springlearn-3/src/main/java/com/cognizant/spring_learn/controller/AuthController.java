package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate()");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = getUser(authHeader); 
        LOGGER.debug("Decoded Username: {}", user);

        Map<String, String> map = new HashMap<>();
        String token = jwtUtil.generateToken(user); // ✅ Generate real JWT token
        map.put("token", token);

        LOGGER.info("End authenticate()");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.info("Start getUser()");
        String encodedCredentials = authHeader.substring("Basic ".length());
        LOGGER.debug("Encoded Credentials: {}", encodedCredentials);

        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
        LOGGER.debug("Decoded String: {}", decodedString);

        String username = decodedString.split(":", 2)[0];
        LOGGER.debug("Extracted Username: {}", username);

        LOGGER.info("End getUser()");
        return username;
    }
}