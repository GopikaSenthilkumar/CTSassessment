package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate()");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("Decoded Username: {}", user);

        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
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

    private String generateJwt(String user) {
        LOGGER.info("Start generateJwt()");

        JwtBuilder builder = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)) // 20 mins
                .signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();
        LOGGER.debug("Generated JWT: {}", token);
        LOGGER.info("End generateJwt()");
        return token;
    }
}