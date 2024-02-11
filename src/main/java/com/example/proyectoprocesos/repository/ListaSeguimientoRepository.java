package com.example.proyectoprocesos.repository;

import com.example.proyectoprocesos.entity.ListaSeguimiento;
import com.example.proyectoprocesos.entity.Objetivos;

import java.util.List;


public interface ListaSeguimientoRepository {
    void añadirLista(ListaSeguimiento listaSeguimiento);

    void borrarLista(Long objetivo);

    void actualizarLista(ListaSeguimiento listaSeguimiento, Long objetivo);

    List<Objetivos> findAll();

    List<String> findMine(String username);

}
