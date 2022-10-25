package com.rest.domain.Service;

import com.rest.domain.Dto.MeasuresDto;
import com.rest.domain.Dto.RiversDto;
import com.rest.domain.Dto.SettlementsDto;
import com.rest.domain.Repository.SettlementsRepository;
import com.rest.domain.domain.Measures;
import com.rest.domain.domain.Rivers;
import com.rest.domain.domain.Settlements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SettlementsService{

    public SettlementsRepository repository;

    @Autowired
    public SettlementsService(@Qualifier("settlementsRepository") SettlementsRepository repository) {
        this.repository = repository;
    }

    public List<MeasuresDto> findMeasuresBySettlements(Integer id) {
        Optional<Settlements> stlmnts = repository.findById(id);
        return stlmnts.get().getMsrs().stream().map(this::convertToDtoMeasures).collect(Collectors.toList());
    }

//    public List<RiversDto> findRiversBySettlements(Integer id) {
//        Optional<Settlements> stlmnts = repository.findById(id);
//        return stlmnts.get().getRivers().stream().map(this::convertToDtoRivers).collect(Collectors.toList());
//    }

    public List<SettlementsDto> findAll(){
        return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public SettlementsDto convertToDto(Settlements stlmnts){
        SettlementsDto stlmntsDto = new SettlementsDto();
        stlmntsDto.setId(stlmnts.getId());
        stlmntsDto.setName(stlmnts.getName());
        stlmntsDto.setGps_latitude(stlmnts.getGps_latitude());
        stlmntsDto.setGps_longtitude(stlmnts.getGps_longtitude());
        return stlmntsDto;
    }

//    public RiversDto convertToDtoRivers(Rivers rvr){
//        RiversDto rvrsDto = new RiversDto();
//        rvrsDto.setId(rvr.getId());
//        rvrsDto.setName(rvr.getName());
//        return rvrsDto;
//    }

    public MeasuresDto convertToDtoMeasures(Measures msrs){
        MeasuresDto msrsDto = new MeasuresDto();
        msrsDto.setId(msrs.getId());
        msrsDto.setWater_level(msrs.getWater_level());
        msrsDto.setDate(msrs.getDate());
        msrsDto.setSettlements_id(msrs.getSettlements_id().getId());
        return msrsDto;
    }
}
