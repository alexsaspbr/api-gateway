package br.com.ada.apigateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Route {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("products_route", r -> r.path("/products/**")
                        .uri("http://localhost:8080"))
                .route("shop_route", r -> r.path("/shop/**")
                        .uri("http://localhost:8082"))
                .build();
    }

}
