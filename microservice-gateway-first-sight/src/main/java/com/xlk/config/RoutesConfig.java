package com.xlk.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Function;

@Configuration
public class RoutesConfig {

	@Bean
	public RouteLocator myRoute(RouteLocatorBuilder build) {
		
		Function<PredicateSpec, Route.AsyncBuilder> fn = new Function<PredicateSpec, Route.AsyncBuilder>() {
            public Route.AsyncBuilder apply(PredicateSpec t) {
                t.path("/hello");
                return t.uri("http://localhost:8080");
            }
        };
		return build.routes().route(fn).build();
	}
}
