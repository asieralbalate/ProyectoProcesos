package com.example.proyectoprocesos.security;

import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Constants {
    public static final String BASE_URL = "http://localhost:8080";
    public static final String LOGIN_URL = "http://localhost:8080/login";
    public static final String SIGN_UP = "http://localhost:8080/signup";

    public static final String ADMIN_URL = "http://localhost:8080/admin/metas";
    public static final String ASESOR_URL = "http://localhost:8080/asesor/objetivos";
    public static final String USUARIO_URL = "http://localhost:8080/usuario/listaseguimiento";


    public static final String SECRET_KEY = "1234567890123456"; // Clave secreta para AES (16, 24 o 32 bytes)
    public static final String INIT_VECTOR = "1234567890123456"; // Vector de inicialización (16 bytes)

    public static final String SUPER_SECRET_KEY = "ZnJhc2VzbGFyZ2FzcGFyYWNvbG9jYXJjb21vY2xhdmVlbnVucHJvamVjdG9kZWVtZXBsb3BhcmFqd3Rjb25zcHJpbmdzZWN1cml0eQ==bWlwcnVlYmFkZWVqbXBsb3BhcmFiYXNlNjQ=";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

    public static final String HEADER_AUTHORIZACION_KEY = "token";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";


    public static Key getSigningKey(String secret) {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
