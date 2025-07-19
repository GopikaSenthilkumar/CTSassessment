package com.cognizant.api_gateways.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("/customer/hello")
    public String customerHello() {
        return "Hello from Customer Service!";
    }

    @GetMapping("/billing/hello")
    public String billingHello() {
        return "Hello from Billing Service!";
    }
}