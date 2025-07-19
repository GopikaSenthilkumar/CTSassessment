package com.cognizant.api_gateway.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Configuration
public class LoadBalancerConfiguration {

    @Bean
    public ServiceInstanceListSupplier staticInstanceListSupplier() {
        return new ServiceInstanceListSupplier() {
            @Override
            public String getServiceId() {
                return "example-service"; // This must match the lb://example-service URI
            }

            @Override
            public Flux<List<ServiceInstance>> get() {
                List<ServiceInstance> instances = Arrays.asList(
                    new DefaultServiceInstance("example-service-1", "example-service", "localhost", 8081, false),
                    new DefaultServiceInstance("example-service-2", "example-service", "localhost", 8082, false)
                );
                return Flux.just(instances);
            }
        };
    }
}
