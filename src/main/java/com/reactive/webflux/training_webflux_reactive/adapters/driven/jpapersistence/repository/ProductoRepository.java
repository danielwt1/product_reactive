package com.reactive.webflux.training_webflux_reactive.adapters.driven.jpapersistence.repository;

import com.reactive.webflux.training_webflux_reactive.adapters.driven.jpapersistence.entity.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends ReactiveCrudRepository<Producto,Long> {
}
