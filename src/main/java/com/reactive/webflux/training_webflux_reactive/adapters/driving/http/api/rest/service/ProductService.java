package com.reactive.webflux.training_webflux_reactive.adapters.driving.http.api.rest.service;

import com.reactive.webflux.training_webflux_reactive.adapters.driving.http.api.rest.dto.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<String> save(ProductDTO producto);
    Mono<String> update(ProductDTO producto,Integer id);

    Mono<String> delete(Integer producto);
    Flux<ProductDTO> findAll();

}
