package com.rest.domain.Controller;

import com.rest.domain.Dto.MeasuresDto;
import com.rest.domain.Service.MeasuresService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class MeasuresController {

    private final MeasuresService msrs;

    MeasuresController(MeasuresService msrs) {
        this.msrs = msrs;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/measures")
    List<MeasuresDto> all() {
        return msrs.findAll();
    }
}