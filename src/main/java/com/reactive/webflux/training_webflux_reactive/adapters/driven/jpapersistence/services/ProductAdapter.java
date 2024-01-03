package com.reactive.webflux.training_webflux_reactive.adapters.driven.jpapersistence.services;


import com.reactive.webflux.training_webflux_reactive.adapters.driven.jpapersistence.entity.Producto;
import com.reactive.webflux.training_webflux_reactive.adapters.driven.jpapersistence.repository.ProductoRepository;
import com.reactive.webflux.training_webflux_reactive.domain.model.ProductModel;
import com.reactive.webflux.training_webflux_reactive.domain.ports.driven.ProductPersistencePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductAdapter implements ProductPersistencePort {
    private final ProductoRepository repository;

    public ProductAdapter(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<ProductModel> getAllProducts() {
        return this.repository.findAll().map(el -> new ProductModel(el.getId(),el.getNombre(),el.getPrecio()));
    }

    @Override
    public Mono<ProductModel> getProductById(Integer id) {
        return this.repository.findById(Long.valueOf(id)).map(el -> new ProductModel(el.getId(),el.getNombre(),el.getPrecio()));
    }

    @Override
    public Mono<ProductModel> saveNewProduct(ProductModel productModel) {
        return this.repository
                .save(new Producto(productModel.getId(),productModel.getNombre(),productModel.getPrecio()))
                .map(el -> new ProductModel(el.getId(),el.getNombre(),el.getPrecio()));
    }

    @Override
    public Mono<ProductModel> updateNewProduct(ProductModel productModel) {
        return this.saveNewProduct(productModel);
    }

    @Override
    public Mono<Void> deleteNewProduct(Integer id) {
        return this.repository.deleteById(Long.valueOf(id));
    }

    @Override
    public Mono<ProductModel> getByName(Long id,String name) {
        return this.repository.fidnByName(id,name).map(el -> new ProductModel(el.getId(),el.getNombre(),el.getPrecio()));
    }
}
