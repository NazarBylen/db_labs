package com.rest.domain.Service;

import com.rest.domain.Dto.RiversDto;
import com.rest.domain.Repository.RiversRepository;
import com.rest.domain.domain.Rivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiversService implements GeneralServiceInterface<Rivers, Integer>{
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

//    public RiversDto create(Rivers rvrs){
//        RiversDto riv = new RiversDto();
//        riv.setId(rvrs.getId());
//        riv.setName(rvrs.getName());
//        repository.save(rvrs);
//        return riv;
//    }
//
//    public RiversDto update(Integer id, Rivers rvrs){
//        if (repository.findById(id).isEmpty()) {
//            throw new NullPointerException("Parameter Id cannot be found");
//        } else {
//            RiversDto riv = new RiversDto();
//            Rivers riv2 = repository.findById(id).get();
//            riv2.setId(id);
//            riv2.setName(rvrs.getName());
//            riv.setId(id);
//            riv.setName(rvrs.getName());
//            repository.save(riv2);
//            return riv;
//        }
//    }
//
//    public RiversDto delete(int id) {
//        Rivers riv2 = repository.findById(id).get();
//        RiversDto riv = new RiversDto();
//        riv.setId(riv2.getId());
//        riv.setName(riv2.getName());
//        repository.deleteById(id);
//        return riv;
//    }
//
//    public RiversDto convertToDto(Rivers rvr){
//        RiversDto rvrsDto = new RiversDto();
//        rvrsDto.setId(rvr.getId());
//        rvrsDto.setName(rvr.getName());
//        return rvrsDto;
//    }
}
