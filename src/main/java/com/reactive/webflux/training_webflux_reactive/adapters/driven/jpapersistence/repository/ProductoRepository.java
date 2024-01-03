package com.reactive.webflux.training_webflux_reactive.adapters.driven.jpapersistence.repository;

import com.reactive.webflux.training_webflux_reactive.adapters.driven.jpapersistence.entity.Producto;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductoRepository extends ReactiveCrudRepository<Producto,Long> {
    @Query("SELECT *  FROM producto WHERE producto.nombre =:name AND producto.id <>:id")
    Mono<Producto> fidnByName(Long id,String name);
}
