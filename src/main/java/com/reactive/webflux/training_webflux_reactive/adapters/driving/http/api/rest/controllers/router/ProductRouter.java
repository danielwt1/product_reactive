package com.reactive.webflux.training_webflux_reactive.adapters.driving.http.api.rest.controllers.router;

import com.reactive.webflux.training_webflux_reactive.adapters.driving.http.api.rest.controllers.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProductRouter {
    private static final String PRODUCT_PATH = "product";
    @Bean
    RouterFunction<ServerResponse> router(ProductHandler handler) {
        return RouterFunctions.route()
                .GET(PRODUCT_PATH, handler::getAll)
                .POST(PRODUCT_PATH, handler::save)
                .PUT(PRODUCT_PATH + "/{id}", handler::update)
                .DELETE(PRODUCT_PATH + "/{id}", handler::delete)
                .build();
    }
}
