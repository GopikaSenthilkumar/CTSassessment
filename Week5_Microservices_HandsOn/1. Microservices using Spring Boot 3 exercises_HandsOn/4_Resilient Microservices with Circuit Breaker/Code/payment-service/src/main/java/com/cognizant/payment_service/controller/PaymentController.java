package com.cognizant.payment_service.controller;

import com.cognizant.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/api/payment/process")
    public String processPayment() {
        return paymentService.callThirdPartyAPI();
    }
}