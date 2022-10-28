package com.rest.domain.Service;

import com.rest.domain.Repository.MeasuresRepository;
import com.rest.domain.Repository.SettlementsRepository;
import com.rest.domain.domain.Measures;
import com.rest.domain.domain.Settlements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MeasuresService implements MeasuresServiceInterface{
    @Autowired
    public MeasuresRepository repository;
    @Autowired
    public SettlementsRepository settlementsRepository;

    public List<Measures> findAll(){
        return repository.findAll();
    }

    @Override
    public Measures findById(Integer id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Transactional
    public Measures create(Measures person) {
        repository.save(person);
        return person;
    }
    @Transactional
    public Measures create(Measures measure, Integer settlementId){
        Settlements settlement = settlementsRepository.findById(settlementId)
                .orElseThrow(null);
        measure.setSettlement(settlement);
        repository.save(measure);
        return measure;
    }

    @Transactional
    public void update(Integer id, Measures measure) {
        Measures currentMeasure = repository.findById(id).orElseThrow(null);
        currentMeasure.setId(id);
        currentMeasure.setWater_level(measure.getWater_level());
        currentMeasure.setDate(measure.getDate());
        repository.save(currentMeasure);
    }

    @Transactional
    public void update(Integer measureId, Measures measure, Integer settlementId) {
        Settlements settlement = settlementsRepository.findById(settlementId)
                .orElseThrow(null);
        Measures currentMeasure = repository.findById(measureId)
                .orElseThrow(null);
        //update
        currentMeasure.setWater_level(measure.getWater_level());
        currentMeasure.setDate(measure.getDate());
        currentMeasure.setSettlement(settlement);
        repository.save(currentMeasure);
    }

    @Transactional
    public void delete(Integer id) {
        Measures measure = repository.findById(id).orElseThrow(null);
        repository.delete(measure);
    }
}
