package com.rest.domain.Controller;

import com.rest.domain.Dto.MeasuresDto;
import com.rest.domain.Dto.RiversDto;
import com.rest.domain.Dto.SettlementsDto;
import com.rest.domain.Service.SettlementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class SettlementsController {
    @Autowired
    private final SettlementsService stlmnts;

    SettlementsController(SettlementsService stlmnts) {
        this.stlmnts = stlmnts;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/settlements")
    List<SettlementsDto> all() {
        return stlmnts.findAll();
    }

    @GetMapping("/{id}/measures")
    List<MeasuresDto> allMeasures(@PathVariable Integer id) {
        return stlmnts.findMeasuresBySettlements(id);
    }

//    @GetMapping("/{id}/rivers")
//    List<RiversDto> allRivers(@PathVariable Integer id) {
//        return stlmnts.findRiversBySettlements(id);
//    }
}