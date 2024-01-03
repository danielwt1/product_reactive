package com.reactive.webflux.training_webflux_reactive.domain.ports.driving;

import com.reactive.webflux.training_webflux_reactive.domain.model.ProductModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductApiPort {
    Flux<ProductModel> getAllProducts();
    Mono<ProductModel> getProductById(Integer id);
    Mono<String> saveNewProduct(ProductModel productModel);
    Mono<String> updateNewProduct(Integer id, ProductModel productModel);
    Mono<String>deleteNewProduct(Integer id);

}
