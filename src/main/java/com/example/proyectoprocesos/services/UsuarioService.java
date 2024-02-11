package com.example.proyectoprocesos.services;

import com.example.proyectoprocesos.entity.Usuario;
import com.example.proyectoprocesos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void saveUser(Usuario user) {
        usuarioRepository.saveUsuario(user);
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.getUsuarios();
    }
}
