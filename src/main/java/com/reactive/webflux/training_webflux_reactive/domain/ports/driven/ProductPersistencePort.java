package com.reactive.webflux.training_webflux_reactive.domain.ports.driven;

import com.reactive.webflux.training_webflux_reactive.domain.model.ProductModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductPersistencePort {
    Flux<ProductModel> getAllProducts();
    Mono<ProductModel> getProductById(Integer id);
    Mono<ProductModel> saveNewProduct(ProductModel productModel);
    Mono<ProductModel> updateNewProduct(ProductModel productModel);
    Mono<Void>deleteNewProduct(Integer id);
    Mono<ProductModel> getByName(Long id,String name);
}
