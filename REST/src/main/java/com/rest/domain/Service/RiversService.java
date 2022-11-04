package com.rest.domain.Service;

import com.rest.domain.Dto.SettlementsDto;
import com.rest.domain.Repository.RiversRepository;
import com.rest.domain.domain.Rivers;
import com.rest.domain.domain.Settlements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RiversService implements RiversServiceInterface {
    public RiversRepository repository;

    @Autowired
    public RiversService(@Qualifier("riversRepository") RiversRepository repository) {
        this.repository = repository;
    }

    public List<Rivers> findAll(){
        return repository.findAll();
    }

    public Rivers findById(Integer id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Transactional
    public Rivers create(Rivers river){
        repository.save(river);
        return river;
    }

    @Transactional
    public void update(Integer id, Rivers river) {
        Rivers currentRiver = repository.findById(id).orElseThrow(null);
        currentRiver.setId(id);
        currentRiver.setName(river.getName());
        repository.save(currentRiver);
    }

    @Transactional
    public void delete(Integer id) {
        Rivers river = repository.findById(id).orElseThrow(null);
        repository.delete(river);
    }

    public List<Settlements> findSettlementsByRiverId(Integer riverId) {
        Rivers river = repository.findById(riverId).orElseThrow(null);
        return river.getSettlements_rivers().stream().toList();
    }
}
