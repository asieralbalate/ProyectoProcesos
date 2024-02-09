package com.example.proyectoprocesos.services;

import com.example.proyectoprocesos.entity.Objetivos;
import com.example.proyectoprocesos.repository.ObjetivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetivoService implements IObjetivoService{

    private ObjetivosRepository objetivosRepository;

    @Autowired
    public ObjetivoService(ObjetivosRepository objetivosRepository){
        this.objetivosRepository = objetivosRepository;
    }
    @Override
    public void crearObjetivo(Objetivos objetivos) {
        objetivosRepository.crearObjetivo(objetivos);
    }

    @Override
    public void borrarObjetivo(Long id) {
        objetivosRepository.borrarObjetivo(id);
    }

    @Override
    public void actualizarObjetivo(Objetivos objetivos, Long id) {
        objetivosRepository.actualizarObjetivo(objetivos, id);
    }

    @Override
    public List<Objetivos> findAll() {
        return objetivosRepository.findAll();
    }

    @Override
    public List<Objetivos> findMine(String username) {
        return objetivosRepository.findMine(username);
    }

    @Override
    public Objetivos findById(Long id) {
        return objetivosRepository.findById(id);
    }
}
