package com.Nazar.NazarBylen.dao.impl;

import com.Nazar.NazarBylen.dao.RiversDao;
import com.Nazar.NazarBylen.dao.RiversSettlementsDao;
import com.Nazar.NazarBylen.domain.RiversSettlements;
import com.sun.jdi.IntegerValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class RiversSettlementsImpl implements RiversSettlementsDao {
    private static final String FIND_ALL = "SELECT * FROM rivers_settlements";
    private static final String CREATE = "INSERT rivers_settlements(rivers_id, settlements_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE rivers_settlements SET rivers_id=?, settlements_id WHERE id=?";

    private static final String DELETE = "DELETE FROM rivers_settlements WHERE id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<RiversSettlements> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(RiversSettlements.class));
    }

    @Override
    public Optional<RiversSettlements> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public int create(RiversSettlements rivers_s) {
        return jdbcTemplate.update(CREATE, Integer.valueOf(rivers_s.getRivers_id()), Integer.valueOf(rivers_s.getSettlements_id()));
    }

    @Override
    public int update(Integer id, RiversSettlements rivers_s) {
        return jdbcTemplate.update(UPDATE, rivers_s.getRivers_id(), rivers_s.getSettlements_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
