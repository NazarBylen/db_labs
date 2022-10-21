package com.Nazar.NazarBylen.dao.impl;

import com.Nazar.NazarBylen.dao.SettlementsDao;
import com.Nazar.NazarBylen.domain.Settlements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class SettlementsImpl implements SettlementsDao {
    private static final String FIND_ALL = "SELECT * FROM settlements";
    private static final String CREATE = "INSERT settlements(name, gps_latitude, gps_longtitude) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE settlements SET name=?, gps_latitude=?, gps_longtitude=? WHERE id=?";

    private static final String DELETE = "DELETE FROM settlements WHERE id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Settlements> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Settlements.class));
    }

    @Override
    public Optional<Settlements> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public int create(Settlements settlements) {
        return jdbcTemplate.update(CREATE, settlements.getName(), Double.valueOf(settlements.getGps_latitude()), Double.valueOf(settlements.getGps_longtitude()));
    }

    @Override
    public int update(Integer id, Settlements settlements) {
        return jdbcTemplate.update(UPDATE, settlements.getName(), Double.valueOf(settlements.getGps_latitude()), Double.valueOf(settlements.getGps_longtitude()), Integer.valueOf(id));
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
