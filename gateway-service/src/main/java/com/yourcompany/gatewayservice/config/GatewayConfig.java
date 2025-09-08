package com.yourcompany.gatewayservice.config;



import org.springframework.cloud.gatewayservice.route.RouteLocator;
import org.springframework.cloud.gatewayservice.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r.path("/api/auth/**")
                        .uri("http://localhost:8081"))
                .route("booking-service", r -> r.path("/api/bookings/**")
                        .uri("http://localhost:8082"))
                .build();
    }
}
