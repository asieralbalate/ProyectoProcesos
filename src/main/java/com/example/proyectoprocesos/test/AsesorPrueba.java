package com.example.proyectoprocesos.test;

import com.example.proyectoprocesos.entity.Objetivos;
import com.example.proyectoprocesos.security.Constants;
import org.springframework.http.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class AsesorPrueba {
    private final RestTemplate restTemplate = new RestTemplate();

    private String token;

    public AsesorPrueba(String username, String password) {
        this.token = autentificarse(username, password);
    }

    private String autentificarse(String username, String password) {
        return restTemplate.postForObject(Constants.LOGIN_URL + "?user={username}&encryptedPass={encryptedPass}", null, String.class, username, password);
    }

    public void createNew(Objetivos objetivos) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constants.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<Objetivos> requestEntity = new HttpEntity<>(objetivos, headers);
        try {
            restTemplate.postForEntity(Constants.ASESOR_URL, requestEntity, Void.class);
            System.out.println("Nuevo objetivo creado");
        } catch (HttpServerErrorException e) {
            System.out.println("Fallo al crear el objetivo. Id duplicado");
        }
    }


    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.HEADER_AUTHORIZACION_KEY, token);
        ResponseEntity<String> responseAll = restTemplate.exchange(Constants.ASESOR_URL, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("Todos los objetivos");
        System.out.println(responseAll.getBody());
    }

    public void getByID(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.HEADER_AUTHORIZACION_KEY, token);
        ResponseEntity<String> responseAll = restTemplate.exchange(Constants.ASESOR_URL + "/" + id, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("objetivos con id: " + id);
        System.out.println(responseAll.getBody());

    }

    public void getMine() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.HEADER_AUTHORIZACION_KEY, token);
        ResponseEntity<String> responseAll = restTemplate.exchange(Constants.ASESOR_URL + "/mine", HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("Todos mis objetivos");
        System.out.println(responseAll.getBody());
    }

    public void actualizarPorId(Objetivos objetivos, Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constants.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<Objetivos> requestEntity = new HttpEntity<>(objetivos, headers);

        restTemplate.put(Constants.ASESOR_URL + "/" + id, requestEntity);
        System.out.println("Objetivo actualizado");
    }


    public void borrar(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constants.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        restTemplate.exchange(Constants.ASESOR_URL + "/" + id, HttpMethod.DELETE, requestEntity, String.class);
        System.out.println("Objetivo borrado");
        System.out.println();
    }

    public static void main(String[] args) {
        AsesorPrueba p = new AsesorPrueba("Gonzalo", "hola01");
        AsesorPrueba p2 = new AsesorPrueba("Borjiloli", "hola01");
    }
}
