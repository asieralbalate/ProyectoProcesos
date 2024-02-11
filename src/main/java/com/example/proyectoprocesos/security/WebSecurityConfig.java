package com.example.proyectoprocesos.security;

import com.example.proyectoprocesos.entity.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Autowired
    JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests( authz -> authz
                        .requestMatchers("/admin/**").hasAuthority("ROLE_" + Rol.ADMIN)
                        .requestMatchers("/asesor/**").hasAuthority("ROLE_" + Rol.ASESOR)
                        .requestMatchers("/usuario/**").hasAuthority("ROLE_" + Rol.USUARIO)
                        .requestMatchers(HttpMethod.DELETE, "/admin/metas/**").hasAuthority("ROLE_" + Rol.ADMIN)
                        .requestMatchers(HttpMethod.PUT, "/admin/metas/**").hasAuthority("ROLE_" + Rol.ADMIN)
                        .requestMatchers(HttpMethod.DELETE, "/asesor/objetivos/**").hasAuthority("ROLE_" + Rol.ASESOR)
                        .requestMatchers(HttpMethod.PUT, "/asesor/objetivos/**").hasAuthority("ROLE_" + Rol.ASESOR)
                        .anyRequest().permitAll())
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
