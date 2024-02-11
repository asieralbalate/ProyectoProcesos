package com.example.proyectoprocesos.controllers;

import com.example.proyectoprocesos.entity.ListaSeguimiento;
import com.example.proyectoprocesos.entity.Objetivos;
import com.example.proyectoprocesos.services.IListaSeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario/listaseguimiento")
public class ListaSeguimientoController {

    private final IListaSeguimientoService iListaSeguimientoService;

    @Autowired
    public ListaSeguimientoController(IListaSeguimientoService iListaSeguimientoService) {
        this.iListaSeguimientoService = iListaSeguimientoService;
    }

    @GetMapping
    public List<Objetivos> listAll(){
        return iListaSeguimientoService.findAll();
    }

    @GetMapping("/username/{username}")
    public List<String> findMine(@PathVariable String username){
        return iListaSeguimientoService.findMine(username);
    }

    @PostMapping
    public void crearLista(@RequestBody ListaSeguimiento listaSeguimiento){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentName = authentication.getName();
        listaSeguimiento.setUsername(currentName);
        iListaSeguimientoService.crearLista(listaSeguimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminarLista(@PathVariable Long id){
        iListaSeguimientoService.borrarLista(id);
    }
}
