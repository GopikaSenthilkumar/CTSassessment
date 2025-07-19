package com.cognizant.example_service00.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "false") boolean delay) throws InterruptedException {
        if (delay) {
            Thread.sleep(5000); // Delay only when delay=true
        }
        return "Hello from example-service!";
    }
}
