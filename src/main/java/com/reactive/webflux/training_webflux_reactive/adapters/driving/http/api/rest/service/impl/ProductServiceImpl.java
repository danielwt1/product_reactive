package com.reactive.webflux.training_webflux_reactive.adapters.driving.http.api.rest.service.impl;

import com.reactive.webflux.training_webflux_reactive.adapters.driving.http.api.rest.dto.ProductDTO;
import com.reactive.webflux.training_webflux_reactive.adapters.driving.http.api.rest.service.ProductService;
import com.reactive.webflux.training_webflux_reactive.domain.model.ProductModel;
import com.reactive.webflux.training_webflux_reactive.domain.ports.driving.ProductApiPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductApiPort apiPort;

    public ProductServiceImpl(ProductApiPort apiPort) {
        this.apiPort = apiPort;
    }

    @Override
    public Mono<String> save(ProductDTO producto) {
        return this.apiPort.saveNewProduct(new ProductModel(producto.getId(),producto.getNombre(),producto.getPrecio()));
    }

    @Override
    public Mono<String> update(ProductDTO producto, Integer id) {
        return this.apiPort.updateNewProduct(id,new ProductModel(producto.getId(),producto.getNombre(),producto.getPrecio()));

    }

    @Override
    public Mono<String> delete(Integer producto) {
        return this.apiPort.deleteNewProduct( producto);
    }

    @Override
    public Flux<ProductDTO> findAll() {
        return this.apiPort.getAllProducts()
                .map(p -> new ProductDTO(p.getId(),p.getNombre(),p.getPrecio()));
    }
}
