package com.example.proyectoprocesos.test;

import com.example.proyectoprocesos.entity.Rol;
import com.example.proyectoprocesos.entity.Usuario;
import com.example.proyectoprocesos.security.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class CrearUsuarios {

    private  static final RestTemplate restTemplate = new RestTemplate();

    private static void createUser(Usuario nuevoUsuario){
        try {
            restTemplate.postForObject(Constants.SIGN_UP, nuevoUsuario, Usuario.class);
            System.out.println("Nuevo usuario creado");

        } catch (HttpServerErrorException errorException){
            System.out.println("Ya existe un usuario con ese nombre :(");
        }
    }

    private static void listUser(){
        ResponseEntity<String> responseAll = restTemplate.getForEntity(Constants.SIGN_UP, String.class);
        System.out.println(responseAll.getBody());
    }

    public static void main(String[] args) {
        CrearUsuarios.createUser(new Usuario("Asier", "hola01", Rol.ASESOR.getRol()));
        CrearUsuarios.listUser();
    }
}

