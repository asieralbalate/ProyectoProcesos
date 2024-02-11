package com.example.proyectoprocesos.repository;

import com.example.proyectoprocesos.entity.ListaSeguimiento;
import com.example.proyectoprocesos.entity.Objetivos;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListaSeguimientoImpl implements ListaSeguimientoRepository{

    private final JdbcTemplate jdbcTemplate;

    public ListaSeguimientoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void añadirLista(ListaSeguimiento listaSeguimiento) {
        String sql = "INSERT INTO listaseguimiento (id, objetivo, username) VALUES (?, ? ,?);";
        jdbcTemplate.update(sql,listaSeguimiento.getId() ,listaSeguimiento.getObjetivo(), listaSeguimiento.getUsername());
    }

    @Override
    public void borrarLista(Long objetivo) {
        String sql = "DELETE FROM listaseguimiento WHERE objetivo = ?";
        jdbcTemplate.update(sql, objetivo);
    }

    @Override
    public void actualizarLista(ListaSeguimiento listaSeguimiento, Long objetivo) {
        String sql = "UPDATE listaseguimiento SET username = ? WHERE objetivo = ?";
        jdbcTemplate.update(sql, listaSeguimiento.getUsername(), listaSeguimiento.getObjetivo());
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
    public List<String> findMine(String username) {
        String sql = "SELECT o.nombre " +
                "FROM listaseguimiento ls " +
                "JOIN objetivos o ON ls.objetivo = o.id " +
                "WHERE ls.username = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{username}, String.class);
    }
}
