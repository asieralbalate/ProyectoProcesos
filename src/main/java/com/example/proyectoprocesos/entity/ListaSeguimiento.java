package com.example.proyectoprocesos.entity;

public class ListaSeguimiento {

    private Long id;
    private Long objetivo;

    private String username;

    public ListaSeguimiento(Long id, Long objetivo, String username) {
        this.id = id;
        this.objetivo = objetivo;
        this.username = username;
    }

    public Long getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Long objetivo) {
        this.objetivo = objetivo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
