package com.example.proyectoprocesos.services;

import com.example.proyectoprocesos.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    void saveUser(Usuario user);
    List<Usuario> getUsuarios();
}
