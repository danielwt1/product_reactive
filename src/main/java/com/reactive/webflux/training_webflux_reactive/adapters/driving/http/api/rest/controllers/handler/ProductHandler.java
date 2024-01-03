package com.reactive.webflux.training_webflux_reactive.adapters.driving.http.api.rest.controllers.handler;

import com.reactive.webflux.training_webflux_reactive.adapters.driving.http.api.rest.dto.ProductDTO;
import com.reactive.webflux.training_webflux_reactive.adapters.driving.http.api.rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class ProductHandler {
    private final ProductService apiPort;

    public ProductHandler(ProductService apiPort) {
        this.apiPort = apiPort;
    }
    public Mono<ServerResponse> getAll(ServerRequest request){
        Flux<ProductDTO> response = this.apiPort.findAll();
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response,ProductDTO.class);
    }

    public Mono<ServerResponse>save(ServerRequest request){
        Mono<ProductDTO> body = request.bodyToMono(ProductDTO.class);

        return body.flatMap(p -> ServerResponse.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON).body(this.apiPort.save(p),ProductDTO.class));
    }
    public Mono<ServerResponse>update(ServerRequest request){
        int id = Integer.parseInt(request.pathVariable("id"));
        Mono<ProductDTO> body = request.bodyToMono(ProductDTO.class);
        return body.flatMap(p -> ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON).body(this.apiPort.update(p,id),ProductDTO.class));

    }
    public Mono<ServerResponse>delete(ServerRequest request){
        int id = Integer.parseInt(request.pathVariable("id"));
        Mono<String> response = this.apiPort.delete(id);
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response,String.class);
    }
}
