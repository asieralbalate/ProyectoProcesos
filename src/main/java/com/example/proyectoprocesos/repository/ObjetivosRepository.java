package com.example.proyectoprocesos.repository;

import com.example.proyectoprocesos.entity.Objetivos;

import java.util.List;

public interface ObjetivosRepository {
    void crearObjetivo(Objetivos objetivos);
    void borrarObjetivo(Long id);
    void actualizarObjetivo(Objetivos objetivos, Long id);
    List<Objetivos> findAll();

    List<Objetivos> findMine(String username);
    Objetivos findById(Long id);
}
