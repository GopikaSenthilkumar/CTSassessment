package com.cognizant.payment_service.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Random; 
import java.util.concurrent.TimeoutException; 

@Service
public class PaymentService {
    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private static final String CB_NAME = "paymentServiceCB";
    @CircuitBreaker(name = CB_NAME, fallbackMethod = "fallbackForAPI")
    public String callThirdPartyAPI() {
        logger.info("Calling third-party payment API..."); 
        simulateAPIScenario(); // Renamed for clarity
        return "Payment processed successfully!";
    }
    public String fallbackForAPI(Exception ex) {
        logger.warn("CircuitBreaker '{}' triggered fallback. Reason: {}", 
                   CB_NAME, ex.getMessage());
        
        if (ex instanceof TimeoutException) {
            return "Payment service timeout. Please retry later.";
        } else if (ex instanceof RuntimeException) {
            return "Payment temporarily unavailable. Please try again later.";
        }
        return "Payment service unavailable.";
    }

    private void simulateAPIScenario() {
        try {
            int scenario = new Random().nextInt(3);
                 switch (scenario) {
                case 0:
                    throw new RuntimeException("API Unavailable");
                case 1:
                    Thread.sleep(3500);
                    throw new RuntimeException("Slow API Response");
                case 2: 
                    Thread.sleep(200);
                    break;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted", e);
        }
    }
}