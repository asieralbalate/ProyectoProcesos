package com.example.proyectoprocesos.controllers;

import com.example.proyectoprocesos.entity.Usuario;
import com.example.proyectoprocesos.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class SignUpController {

    @Autowired
    IUsuarioService iUsuarioService;

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody Usuario user) {
        iUsuarioService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente");
    }

    @GetMapping("signup")
    public List<Usuario> obtenerTodos() {
        return iUsuarioService.getUsuarios();
    }
}
