package com.example.proyectoprocesos.repository;

import com.example.proyectoprocesos.entity.Metas;

import java.util.List;

public interface MetasRepository {
    void crearMetas(Metas metas);
    void borrarMeta(Long id);
    void actualizarMeta(Metas meta, Long id);
    List<Metas> findAll();
    Metas findById(Long id);

}
