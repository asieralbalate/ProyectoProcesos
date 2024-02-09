package com.example.proyectoprocesos.controllers;

import com.example.proyectoprocesos.entity.Metas;
import com.example.proyectoprocesos.services.IMetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/metas")
public class MetasController {

    private final IMetasService iMetasService;

    @Autowired
    public MetasController(IMetasService iMetasService) {
        this.iMetasService = iMetasService;
    }

    @GetMapping
    public List<Metas> listarTodas() {
        return iMetasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metas> findById(@PathVariable Long id) {
        Metas metas = iMetasService.findById(id);
        if (metas != null) {
            return new ResponseEntity<>(metas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void nuevaMeta(@RequestBody Metas metas){
       iMetasService.crearMetas(metas);
    }

    @PostMapping("/{id}")
    public void actualizarMeta(@RequestBody Metas metas, @PathVariable Long id){
        iMetasService.actualizarMeta(metas, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarMeta(@PathVariable Long id){
        iMetasService.borrarMeta(id);
    }
}
