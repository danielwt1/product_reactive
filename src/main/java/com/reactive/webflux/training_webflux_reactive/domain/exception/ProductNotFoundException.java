package com.reactive.webflux.training_webflux_reactive.domain.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
