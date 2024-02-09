package com.example.proyectoprocesos.controllers;

import com.example.proyectoprocesos.entity.Usuario;
import com.example.proyectoprocesos.repository.UsuarioRepository;
import com.example.proyectoprocesos.security.JWTAuthenticationConfig;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    JWTAuthenticationConfig jwtAuthtenticationConfig;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("login")
    public String login(@RequestParam("user") String username, @RequestParam("encryptedPass") String encryptedPass) throws BadRequestException {

        List<Usuario> usuarios = usuarioRepository.getUsuarios();
        System.out.println(usuarios);
        Usuario usuarioEncontrado = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) &&
                    usuario.getPassword().equals(encryptedPass)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            throw new BadRequestException();
        }

        String token = jwtAuthtenticationConfig.getJWTToken(usuarioEncontrado.getUsername(), usuarioEncontrado.getRol());
        return token;
    }
}
