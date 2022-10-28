package com.rest.domain.Service;

import com.rest.domain.Repository.SettlementsRepository;
import com.rest.domain.domain.Measures;
import com.rest.domain.domain.Rivers;
import com.rest.domain.domain.Settlements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SettlementsService implements SettlementsServiceInterface{

    public SettlementsRepository repository;

    @Autowired
    public SettlementsService(@Qualifier("settlementsRepository") SettlementsRepository repository) {
        this.repository = repository;
    }

    public List<Settlements> findAll(){
        return repository.findAll();
    }

    @Override
    public Settlements findById(Integer id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Transactional
    public Settlements create(Settlements settlement){
        repository.save(settlement);
        return settlement;
    }

    @Transactional
    public void update(Integer id, Settlements settlement) {
        Settlements currentSettlement = repository.findById(id).orElseThrow(null);
        currentSettlement.setId(id);
        currentSettlement.setName(settlement.getName());
        currentSettlement.setGps_latitude(settlement.getGps_latitude());
        currentSettlement.setGps_longtitude(settlement.getGps_longtitude());
        repository.save(currentSettlement);
    }

    @Transactional
    public void delete(Integer id) {
        Settlements settlement = repository.findById(id).orElseThrow(null);
        repository.delete(settlement);
    }

    @Override
    public List<Measures> findMeasuresBySettlementId(Integer id) {
        Settlements settlement = repository.findById(id).orElseThrow(null);
        return settlement.getMeasures().stream().toList();
    }

    @Override
    public List<Rivers> findRiversBySettlementId(Integer id) {
        Settlements settlement = repository.findById(id).orElseThrow(null);;
        return settlement.getRivers().stream().toList();
    }

}
