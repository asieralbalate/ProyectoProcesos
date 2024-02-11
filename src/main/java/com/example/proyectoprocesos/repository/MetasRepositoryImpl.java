package com.example.proyectoprocesos.repository;

import com.example.proyectoprocesos.entity.Metas;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MetasRepositoryImpl implements MetasRepository{
    private final JdbcTemplate jdbcTemplate;

    public MetasRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public void crearMetas(Metas metas) {
        String sql = "INSERT INTO metas (id, nombre, descripcion) VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, metas.getId(), metas.getNombre(), metas.getDescripcion());
    }


    @Override
    public void borrarMeta(Long id) {
        String sql = "DELETE FROM metas WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void actualizarMeta(Metas meta, Long id) {
        String sql = "UPDATE metas SET nombre = ?, descripcion = ? WHERE id = ?";
        jdbcTemplate.update(sql, meta.getNombre(), meta.getDescripcion(), id);
    }

    @Override
    public List<Metas> findAll() {
        String sql = "SELECT id, nombre, descripcion FROM metas";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Metas(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion")
                ));
    }

    @Transactional
    @Override
    public Metas findById(Long id) {
        String sql = "SELECT id, nombre, descripcion FROM metas WHERE id = ?";
        List<Metas> metas = jdbcTemplate.query(sql, new Object[]{id}, (resultSet, rowNum) ->
                new Metas(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion")
                ));
        return metas.isEmpty() ? null : metas.get(0);
    }
}
