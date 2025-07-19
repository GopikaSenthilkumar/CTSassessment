package com.cognizant.oauth_login.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {

    @GetMapping("/")
    public String home() {
        return "Welcome to OAuth2 Centralized Login App. Visit /user after login.";
    }

    @GetMapping("/user")
    public Principal getUser(Principal principal) {
        return principal;
    }
}
