package com.example.proyectoprocesos.entity;

public enum Rol {
    ADMIN("ADMIN"),
    ASESOR("ASESOR"),
    USUARIO("USUARIO");

    private final String rol;

    Rol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
}
