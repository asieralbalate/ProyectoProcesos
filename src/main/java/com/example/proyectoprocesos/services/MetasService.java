package com.example.proyectoprocesos.services;

import com.example.proyectoprocesos.entity.Metas;
import com.example.proyectoprocesos.repository.MetasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetasService implements IMetasService{
    private MetasRepository metasRepository;

    @Autowired
    public MetasService(MetasRepository metasRepository){
        this.metasRepository = metasRepository;
    }

    @Override
    public void crearMetas(Metas metas) {
        metasRepository.crearMetas(metas);
    }

    @Override
    public void borrarMeta(Long id) {
        metasRepository.borrarMeta(id);
    }

    @Override
    public void actualizarMeta(Metas meta, Long id) {
        metasRepository.actualizarMeta(meta, id);
    }

    @Override
    public List<Metas> findAll() {
        return metasRepository.findAll();
    }

    @Override
    public Metas findById(Long id) {
        return metasRepository.findById(id);
    }
}
