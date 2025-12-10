package campushub.campushub_gateway_service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

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
            .route("notification_service_route", r -> r.path("/campushub-notification-service/**")
                    .filters(f -> f.rewritePath("/campushub-notification-service/(?<remaining>.*)", "/${remaining}"))
                    .uri("lb://campushub-notification-service"))
            .build();
    }

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Arrays.asList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.addAllowedMethod("*");
        corsConfig.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}
