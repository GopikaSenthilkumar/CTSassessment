package com.cognizant.spring_learn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.cognizant.spring_learn.security.JwtConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate()");

        String user = getUser(authHeader);
        LOGGER.info("User: {}", user);

        String token = generateJwt(user);
        LOGGER.info("Generated Token: {}", token);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }

    private String getUser(String authHeader) {
        LOGGER.info("Start getUser()");
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
        String user = credentials.split(":")[0];
        LOGGER.info("End getUser()");
        return user;
    }

    private String generateJwt(String user) {
        LOGGER.info("Start generateJwt()");
        String token = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)) // 20 minutes
                .signWith(JwtConstants.SECRET_KEY)
                .compact();
        return token;
    }
}