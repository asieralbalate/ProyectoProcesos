package com.example.proyectoprocesos.services;

import com.example.proyectoprocesos.entity.ListaSeguimiento;
import com.example.proyectoprocesos.entity.Objetivos;

import java.util.List;

public interface IListaSeguimientoService {
    void crearLista(ListaSeguimiento listaSeguimiento);

    void borrarLista(Long objetivo);

    void actualizarLista(ListaSeguimiento listaSeguimiento, Long objetivo);

    List<Objetivos> findAll();

    List<String> findMine(String username);
}
