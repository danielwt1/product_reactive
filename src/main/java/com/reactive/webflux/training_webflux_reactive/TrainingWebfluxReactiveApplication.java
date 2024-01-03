package com.reactive.webflux.training_webflux_reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingWebfluxReactiveApplication {
    public static final String USECASES_ROUTE= "com.reactive.webflux.training_webflux_reactive.domain.usecase";
    public static final String ADAPTERS_ROUTES= "com.reactive.webflux.training_webflux_reactive.adapters.driven.jpapersistence.services";

    public static void main(String[] args) {
        SpringApplication.run(TrainingWebfluxReactiveApplication.class, args);
    }

}
