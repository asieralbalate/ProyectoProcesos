package com.example.proyectoprocesos.services;


import com.example.proyectoprocesos.entity.ListaSeguimiento;
import com.example.proyectoprocesos.entity.Objetivos;
import com.example.proyectoprocesos.repository.ListaSeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaSeguimientoService implements IListaSeguimientoService {
    private ListaSeguimientoRepository listaSeguimientoRepository;
    @Autowired
    public ListaSeguimientoService(ListaSeguimientoRepository listaSeguimientoRepository){
        this.listaSeguimientoRepository = listaSeguimientoRepository;
    }

    @Override
    public void crearLista(ListaSeguimiento listaSeguimiento) {
        listaSeguimientoRepository.añadirLista(listaSeguimiento);
    }

    @Override
    public void borrarLista(Long objetivo) {
        listaSeguimientoRepository.borrarLista(objetivo);
    }

    @Override
    public void actualizarLista(ListaSeguimiento listaSeguimiento, Long objetivo) {
        listaSeguimientoRepository.actualizarLista(listaSeguimiento, objetivo);
    }

    @Override
    public List<Objetivos> findAll() {
        return listaSeguimientoRepository.findAll();
    }

    @Override
    public List<String> findMine(String username) {
        return listaSeguimientoRepository.findMine(username);
    }
}
