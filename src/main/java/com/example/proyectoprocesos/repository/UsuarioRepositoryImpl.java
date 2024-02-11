package com.example.proyectoprocesos.repository;

import com.example.proyectoprocesos.entity.PasswordEncryptor;
import com.example.proyectoprocesos.entity.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{

    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveUsuario(Usuario user) {
        String sql = "INSERT INTO usuarios (username, password, rol) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), PasswordEncryptor.encrypt(user.getPassword()), user.getRol());
    }

    @Override
    public List<Usuario> getUsuarios() {
        String sql = "SELECT username, password, rol FROM usuarios";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Usuario(
                        resultSet.getString("username"),
                        PasswordEncryptor.decrypt(resultSet.getString("password")),
                        resultSet.getString("rol")
                )
        );
    }
}
