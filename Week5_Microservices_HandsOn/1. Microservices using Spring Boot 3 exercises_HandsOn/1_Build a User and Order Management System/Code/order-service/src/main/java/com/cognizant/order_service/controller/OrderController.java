package com.cognizant.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cognizant.order_service.model.Order;
import com.cognizant.order_service.model.User;
import com.cognizant.order_service.repository.OrderRepository;
import com.cognizant.order_service.external.UserClient;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private UserClient userClient;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return repo.save(order);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getOrderWithUser(@PathVariable Long id) {
        Order order = repo.findById(id).orElseThrow();
        User user = userClient.getUser(order.getUserId());

        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        response.put("user", user);
        return response;
    }
    @DeleteMapping("/reset")
    public void resetUserTable() {
        repo.deleteAll();
    }

}