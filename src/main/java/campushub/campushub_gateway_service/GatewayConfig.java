package campushub.campushub_gateway_service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("user_service_route", r -> r.path("/campushub-user-service/**")
                .filters(f -> f.rewritePath("/campushub-user-service/(?<remaining>.*)", "/${remaining}"))
                .uri("lb://campushub-user-service"))
            .route("salle_service_route", r -> r.path("/campushub-salle-service/**")
                .filters(f -> f.rewritePath("/campushub-salle-service/(?<remaining>.*)", "/${remaining}"))
                .uri("lb://campushub-salle-service"))
            .route("support_service_route", r -> r.path("/campushub-support-service/**")
                .filters(f -> f.rewritePath("/campushub-support-service/(?<remaining>.*)", "/${remaining}"))
                .uri("lb://campushub-support-service"))
            .build();
    }
}
