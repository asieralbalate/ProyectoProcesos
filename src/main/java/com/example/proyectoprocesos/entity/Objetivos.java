package com.example.proyectoprocesos.entity;

import java.util.Date;

public class Objetivos {
    private Long id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;

    private String username;
    private Long meta_id;

    public Objetivos(Long id, String nombre, Date fechaInicio, Date fechaFin, String username, Long meta_id) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.username = username;
        this.meta_id = meta_id;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(Long meta_id) {
        this.meta_id = meta_id;
    }
}
