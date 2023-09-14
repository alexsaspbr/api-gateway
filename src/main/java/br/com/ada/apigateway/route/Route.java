package br.com.ada.apigateway.route;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Route {

    @Value("${host.products}")
    private String hostProducts;
    @Value("${host.shop}")
    private String hostShop;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("products_route", r -> r.path("/products/**")
                        .uri(hostProducts))
                .route("shop_route", r -> r.path("/shop/**")
                        .uri(hostShop))
                .build();
    }

}
