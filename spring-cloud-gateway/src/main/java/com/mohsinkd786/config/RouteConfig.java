package com.mohsinkd786.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route(
//                        r-> r.path("/api/v1/product-service/**")
//                        .uri("http://localhost:8080"))
//                .route(
//                        r-> r.path("/api/v1/hello-spring/**")
//                                .uri("http://localhost:8181"))
//                .build();
//    }
}



// hello-spring
    //localhost:8181
// product-service
    // localhost:8080
