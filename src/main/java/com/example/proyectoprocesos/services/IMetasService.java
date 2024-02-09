package com.example.proyectoprocesos.services;

import com.example.proyectoprocesos.entity.Metas;

import java.util.List;

public interface IMetasService {
    void crearMetas(Metas metas);
    void borrarMeta(Long id);
    void actualizarMeta(Metas meta, Long id);
    List<Metas> findAll();
    Metas findById(Long id);
}
