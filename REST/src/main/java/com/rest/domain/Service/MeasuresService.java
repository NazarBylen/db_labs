package com.rest.domain.Service;

import com.rest.domain.Dto.MeasuresDto;
import com.rest.domain.Repository.MeasuresRepository;
import com.rest.domain.domain.Measures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasuresService{
    public MeasuresRepository repository;

    @Autowired
    public MeasuresService(@Qualifier("measuresRepository") MeasuresRepository repository) {
        this.repository = repository;
    }

    public List<MeasuresDto> findAll(){
        return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public MeasuresDto convertToDto(Measures msrs){
        MeasuresDto msrsDto = new MeasuresDto();
        msrsDto.setId(msrs.getId());
        msrsDto.setWater_level(msrs.getWater_level());
        msrsDto.setDate(msrs.getDate());
        msrsDto.setSettlements_id(msrs.getSettlements_id().getId());
        return msrsDto;
    }
}
