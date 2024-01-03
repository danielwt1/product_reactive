package com.reactive.webflux.training_webflux_reactive.domain.exception;

public class ProductSaveException extends RuntimeException{
    public ProductSaveException(String message) {
        super(message);
    }
}
