package com.Nazar.NazarBylen.dao.impl;

import com.Nazar.NazarBylen.dao.MeasuresDao;
import com.Nazar.NazarBylen.domain.Measures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class MeasuresImpl implements MeasuresDao {
    private static final String FIND_ALL = "SELECT * FROM measures";
    private static final String CREATE = "INSERT measures(water_level, date, settlements_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE measures SET water_level=?, date=?, settlements_id=? WHERE id=?";

    private static final String DELETE = "DELETE FROM measures WHERE id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Measures> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Measures.class));
    }

    @Override
    public Optional<Measures> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public int create(Measures measures) {
        return jdbcTemplate.update(CREATE, Integer.valueOf(measures.getWater_level()), Date.valueOf(measures.getDate()), Integer.valueOf(measures.getSettlements_id()));
    }

    @Override
    public int update(Integer id, Measures measures) {
        return jdbcTemplate.update(UPDATE, Integer.valueOf(measures.getWater_level()), Date.valueOf(measures.getDate()), Integer.valueOf(measures.getSettlements_id()), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
