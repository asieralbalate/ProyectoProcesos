package com.example.proyectoprocesos.entity;

public class Usuario {
    String username;
    String password;
    String rol;

    public Usuario(String username, String encryptedPass, String rol) {
        this.username = username;
        this.password = encryptedPass;
        this.rol = rol;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getRol() {
        return rol;
    }


    public void setRol(String rol) {
        this.rol = rol;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", encryptedPass='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }
}
