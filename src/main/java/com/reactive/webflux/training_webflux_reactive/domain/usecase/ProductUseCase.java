package com.reactive.webflux.training_webflux_reactive.domain.usecase;

import com.reactive.webflux.training_webflux_reactive.domain.exception.ProductNotFoundException;
import com.reactive.webflux.training_webflux_reactive.domain.exception.ProductSaveException;
import com.reactive.webflux.training_webflux_reactive.domain.model.ProductModel;
import com.reactive.webflux.training_webflux_reactive.domain.ports.driven.ProductPersistencePort;
import com.reactive.webflux.training_webflux_reactive.domain.ports.driving.ProductApiPort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductUseCase implements ProductApiPort {
    private final ProductPersistencePort productPersistencePort;

    public ProductUseCase(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public Flux<ProductModel> getAllProducts() {
        return this.productPersistencePort.getAllProducts();
    }

    @Override
    public Mono<ProductModel> getProductById(Integer id) {
        return this.productPersistencePort.getProductById(id);
    }

    @Override
    public Mono<String> saveNewProduct(ProductModel productModel) {
        return this.productPersistencePort.saveNewProduct(productModel)
                .map(p -> "Se guardo nuevo producto");
    }

    @Override
    public Mono<String> updateNewProduct(Integer id, ProductModel product) {
        return productPersistencePort.getProductById(id)
                .hasElement()
                .flatMap(existsId -> Boolean.FALSE.equals(existsId) ? Mono.error(new RuntimeException("Product not found")): productPersistencePort.getByName((long) id, product.getNombre())
                        .hasElement()

                )
                .flatMap(existsName -> {
                    if (Boolean.TRUE.equals(existsName)) {
                        return Mono.error(new RuntimeException("Product name already in use"));
                    }
                    product.setId((long) id);
                    return productPersistencePort.updateNewProduct(product);
                })
                .onErrorMap(e -> new ProductSaveException(String.format("Error al guardar la causa fue : %s", e.getMessage())))
                .doOnError(err-> System.out.println(String.format("Oucrrio el error: %s",err)))
                .thenReturn("Se actualizo");
    }






    @Override
    public Mono<String> deleteNewProduct(Integer id) {

        return this.getProductById(id)
                .switchIfEmpty(Mono.error(new ProductNotFoundException("No se encontro El Producto")))
                .flatMap(p -> this.productPersistencePort.deleteNewProduct(id)
                        .then(Mono.just("Se elimino")));//.then se usa para hacer alguna otra accion despues del flujo si tengo acciones varia podria con publishOn dentro del flujo mandarlas a que se ejecuten en otr p

    }
}
