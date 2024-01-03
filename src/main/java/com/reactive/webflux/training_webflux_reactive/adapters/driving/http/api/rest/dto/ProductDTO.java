package com.reactive.webflux.training_webflux_reactive.adapters.driving.http.api.rest.dto;

public class ProductDTO {
    private Long id;
    private String nombre;
    private Integer precio ;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String nombre, Integer precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
