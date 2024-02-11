package com.example.proyectoprocesos.controllers;

import com.example.proyectoprocesos.entity.Objetivos;
import com.example.proyectoprocesos.services.IObjetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asesor/objetivos")
public class ObjetivosController {

    private final IObjetivoService iObjetivoService;

    @Autowired
    public ObjetivosController(IObjetivoService iObjetivoService) {
        this.iObjetivoService = iObjetivoService;
    }

    @GetMapping
    public List<Objetivos> listAll(){
        return iObjetivoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Objetivos> findById(@PathVariable Long id){
        Objetivos objetivos = iObjetivoService.findById(id);
        if (objetivos != null) {
            return new ResponseEntity<>(objetivos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username/{username}")
    public List<Objetivos> findMine(@PathVariable String username){
        return iObjetivoService.findMine(username);
    }

    @PostMapping
    public void nuevoObjetivo(@RequestBody Objetivos objetivos){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentName = authentication.getName();
        objetivos.setUsername(currentName);
        iObjetivoService.crearObjetivo(objetivos);
    }

    @PutMapping("/{id}")
    public void actualizarObjetivo(@RequestBody Objetivos objetivos, @PathVariable Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentName = authentication.getName();
        objetivos.setUsername(currentName);
        iObjetivoService.actualizarObjetivo(objetivos, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarObjetivo(@PathVariable Long id){
        iObjetivoService.borrarObjetivo(id);
    }
}
