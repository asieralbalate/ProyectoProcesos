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
        String sql = "INSERT INTO objetivo (id, nombre, fechaInicio, fechaFin, username, meta) VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, objetivos.getId(), objetivos.getNombre(), objetivos.getFechaInicio(), objetivos.getFechaFin(), objetivos.getUsername(), objetivos.getMeta());

    }

    @Override
    public void borrarObjetivo(Long id) {
        String sql = "DELETE FROM objetivo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void actualizarObjetivo(Objetivos objetivos, Long id) {
        String sql = "UPDATE objetivo SET nombre = ?, fechaInicio = ?, fechaFin = ?, username = ?, meta = ? WHERE id = ?";
        jdbcTemplate.update(sql, objetivos.getNombre(), objetivos.getFechaInicio(), objetivos.getFechaFin(), objetivos.getUsername(), objetivos.getMeta(), id);
    }

    @Override
    public List<Objetivos> findAll() {
        String sql = "SELECT id, nombre, fechaInicio, fechaFin, username, meta FROM objetivo";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Objetivos(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getDate("fechaInicio"),
                        resultSet.getDate("fechaFin"),
                        resultSet.getString("username"),
                        resultSet.getLong("meta")
                ));
    }

    @Override
    public List<Objetivos> findMine(String username) {
        String sql = "SELECT id, nombre, fechaInicio, fechaFin, username, meta FROM objetivo WHERE username = ?";
        return jdbcTemplate.query(sql, new Object[]{username}, (resultSet, rowNum) ->
                new Objetivos(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getDate("fechaInicio"),
                        resultSet.getDate("fechaFin"),
                        resultSet.getString("username"),
                        resultSet.getLong("meta")
                ));
    }

    @Override
    public Objetivos findById(Long id) {
        String sql = "SELECT id, duracion, hora_inicio, fecha, username, idioma_id FROM objetivo WHERE id = ?";
        List<Objetivos> objetivos = jdbcTemplate.query(sql, new Object[]{id}, (resultSet, rowNum) ->
                new Objetivos(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getDate("fechaInicio"),
                        resultSet.getDate("fechaFin"),
                        resultSet.getString("username"),
                        resultSet.getLong("meta")
                ));
        return objetivos.isEmpty() ? null : objetivos.get(0);
    }
}
