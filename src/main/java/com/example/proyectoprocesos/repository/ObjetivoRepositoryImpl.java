package com.example.proyectoprocesos.repository;

import com.example.proyectoprocesos.entity.Objetivos;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObjetivoRepositoryImpl implements ObjetivosRepository{

    private final JdbcTemplate jdbcTemplate;

    public ObjetivoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void crearObjetivo(Objetivos objetivos) {
        String sql = "INSERT INTO objetivos (id, nombre, fechaInicio, fechaFin, username, meta_id) VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, objetivos.getId(), objetivos.getNombre(), objetivos.getFechaInicio(), objetivos.getFechaFin(), objetivos.getUsername(), objetivos.getMeta_id());

    }

    @Override
    public void borrarObjetivo(Long id) {
        String sql = "DELETE FROM objetivos WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void actualizarObjetivo(Objetivos objetivos, Long id) {
        String sql = "UPDATE objetivos SET nombre = ?, fechaInicio = ?, fechaFin = ?, username = ?, meta_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, objetivos.getNombre(), objetivos.getFechaInicio(), objetivos.getFechaFin(), objetivos.getUsername(), objetivos.getMeta_id(), id);
    }

    @Override
    public List<Objetivos> findAll() {
        String sql = "SELECT id, nombre, fechaInicio, fechaFin, username, meta_id FROM objetivos";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Objetivos(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getDate("fechaInicio"),
                        resultSet.getDate("fechaFin"),
                        resultSet.getString("username"),
                        resultSet.getLong("meta_id")
                ));
    }

    @Override
    public List<Objetivos> findMine(String username) {
        String sql = "SELECT id, nombre, fechaInicio, fechaFin, username, meta_id FROM objetivos WHERE username = ?";
        return jdbcTemplate.query(sql, new Object[]{username}, (resultSet, rowNum) ->
                new Objetivos(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getDate("fechaInicio"),
                        resultSet.getDate("fechaFin"),
                        resultSet.getString("username"),
                        resultSet.getLong("meta_id")
                ));
    }

    @Override
    public Objetivos findById(Long id) {
        String sql = "SELECT id, nombre, fechaInicio, fechaFin, username, meta_id FROM objetivos WHERE id = ?";
        List<Objetivos> objetivos = jdbcTemplate.query(sql, new Object[]{id}, (resultSet, rowNum) ->
                new Objetivos(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getDate("fechaInicio"),
                        resultSet.getDate("fechaFin"),
                        resultSet.getString("username"),
                        resultSet.getLong("meta_id")
                ));
        return objetivos.isEmpty() ? null : objetivos.get(0);
    }
}
