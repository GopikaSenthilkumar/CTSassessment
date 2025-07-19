package com.cognizant.gateway.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ResilienceConfiguration {

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
            .circuitBreakerConfig(customCircuitBreakerConfig())
            .timeLimiterConfig(customTimeLimiterConfig())
            .build());
    }

    private CircuitBreakerConfig customCircuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
            .failureRateThreshold(50)                 // fail if more than 50% fail
            .waitDurationInOpenState(Duration.ofSeconds(10)) // wait before retrying
            .slidingWindowSize(10)                    // check last 10 calls
            .minimumNumberOfCalls(5)
            .build();
    }

    private TimeLimiterConfig customTimeLimiterConfig() {
        return TimeLimiterConfig.custom()
            .timeoutDuration(Duration.ofSeconds(3))   // time limit per call
            .build();
    }
}