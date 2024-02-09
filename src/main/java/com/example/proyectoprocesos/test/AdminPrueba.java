package com.example.proyectoprocesos.test;

import com.example.proyectoprocesos.entity.Metas;
import com.example.proyectoprocesos.security.Constants;
import org.springframework.http.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

class AdminPrueba {

    private final RestTemplate restTemplate = new RestTemplate();

    private String token;

    public AdminPrueba(String username, String password) {
        this.token = autentificarse(username, password);
    }

    private String autentificarse(String username, String password) {
        return restTemplate.postForObject(Constants.LOGIN_URL + "?user={username}&encryptedPass={encryptedPass}", null, String.class, username, password);
    }
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.HEADER_AUTHORIZACION_KEY, token);
        ResponseEntity<String> responseAll = restTemplate.exchange(Constants.ADMIN_URL, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("Todos las metas");
        System.out.println(responseAll.getBody());
    }
    public void getAllbyID(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.HEADER_AUTHORIZACION_KEY, token);
        ResponseEntity<String> responseAll = restTemplate.exchange(Constants.ADMIN_URL + "/" + id, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("Metas con id: " + id);
        System.out.println(responseAll.getBody());

    }
    public void getById(Long id) {
        getAllbyID(id);
    }
    public void createNew(Metas newMeta) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constants.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<Metas> requestEntity = new HttpEntity<>(newMeta, headers);
        try {
            restTemplate.postForEntity(Constants.ADMIN_URL, requestEntity, Void.class);
            System.out.println("Nueva meta creada");
        } catch (HttpServerErrorException e) {
            System.out.println("Fallo al crear la meta. Id duplicado");
        }
    }
    public void actualiazarPorId(Metas updatedMeta, Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constants.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<Metas> requestEntity = new HttpEntity<>(updatedMeta, headers);

        restTemplate.put(Constants.ADMIN_URL + "/" + id, requestEntity);
        System.out.println("Meta actualizada");
    }
    public void borrar(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constants.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        restTemplate.exchange(Constants.ADMIN_URL + "/" + id, HttpMethod.DELETE, requestEntity, String.class);
        System.out.println("Meta borrada");
        System.out.println();
    }
    public static void main(String[] args) {
        AdminPrueba a = new AdminPrueba("Asi", "hola01");

    }
}
