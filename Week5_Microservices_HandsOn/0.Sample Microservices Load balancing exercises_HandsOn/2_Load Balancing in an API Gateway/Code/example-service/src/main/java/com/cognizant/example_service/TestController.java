package com.cognizant.example_service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	  @GetMapping("/loadbalanced/test")
    public String test() {
        return "Response from port 8081";
    }
}