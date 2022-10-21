package com.Nazar.NazarBylen.dao.impl;

import com.Nazar.NazarBylen.dao.RiversDao;
import com.Nazar.NazarBylen.domain.Rivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class RiversImpl implements RiversDao {
    private static final String FIND_ALL = "SELECT * FROM rivers";
    private static final String CREATE = "INSERT rivers(name) VALUES (?)";
    private static final String UPDATE = "UPDATE rivers SET name=? WHERE id=?";

    private static final String DELETE = "DELETE FROM rivers WHERE id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Rivers> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Rivers.class));
    }

    @Override
    public Optional<Rivers> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public int create(Rivers rivers) {
        return jdbcTemplate.update(CREATE, rivers.getName());
    }

    @Override
    public int update(Integer id, Rivers rivers) {
        return jdbcTemplate.update(UPDATE, rivers.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
