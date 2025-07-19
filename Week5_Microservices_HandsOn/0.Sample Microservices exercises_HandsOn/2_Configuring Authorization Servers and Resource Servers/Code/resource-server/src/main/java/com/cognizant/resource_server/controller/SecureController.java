package com.cognizant.resource_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/secure")
    public String secure() {
        return "This is a secure endpoint";
    }

    @GetMapping("/")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }
}