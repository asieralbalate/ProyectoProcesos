package com.example.proyectoprocesos.repository;

import com.example.proyectoprocesos.entity.Usuario;

import java.util.List;

public interface UsuarioRepository {
    void saveUsuario(Usuario user);
    List<Usuario> getUsuarios();
}
