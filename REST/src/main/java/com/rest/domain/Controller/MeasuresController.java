package com.rest.domain.Controller;

import com.rest.domain.Dto.MeasuresDto;
import com.rest.domain.Dto.SettlementsDto;
import com.rest.domain.Dto.assembler.MeasuresDtoAssembler;
import com.rest.domain.Service.MeasuresService;
import com.rest.domain.domain.Measures;
import com.rest.domain.domain.Settlements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/api/measures")
public class MeasuresController {

    @Autowired
    private MeasuresService measuresService;
    @Autowired
    private MeasuresDtoAssembler measuresDtoAssembler;

    MeasuresController(MeasuresService measuresService) {
        this.measuresService = measuresService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<MeasuresDto> getOne(@PathVariable Integer id) {
        Measures measures = measuresService.findById(id);
        MeasuresDto measuresDto = measuresDtoAssembler.toModel(measures);
        return new ResponseEntity<>(measuresDto, HttpStatus.OK);
    }

    @GetMapping("/max-measure")
    public ResponseEntity<Integer> getMaxMeasure() {
        Integer maxMeasure = measuresService.getMaxMeasure();
        return new ResponseEntity<>(maxMeasure, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<MeasuresDto>> getAll() {
        List<Measures> measures = measuresService.findAll();
        CollectionModel<MeasuresDto> measuresDto = measuresDtoAssembler.toCollectionModel(measures);
        return new ResponseEntity<>(measuresDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<MeasuresDto> addMeasure(@RequestBody Measures measure) {
        Measures newMeasure = measuresService.create(measure);
        MeasuresDto measuresDto = measuresDtoAssembler.toModel(newMeasure);
        return new ResponseEntity<>(measuresDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/{settlementId}")
    public ResponseEntity<MeasuresDto> addMeasureWithSettlement(@RequestBody Measures measure, @PathVariable Integer settlementId) {
        Measures newMeasure = measuresService.create(measure, settlementId);
        MeasuresDto measuresDto = measuresDtoAssembler.toModel(newMeasure);
        return new ResponseEntity<>(measuresDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateMeasure(@RequestBody Measures measure, @PathVariable Integer id) {
        measuresService.update(id, measure);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{measureId}/settlements/{settlementId}")
    public ResponseEntity<?> updateMeasureWithSettlement(@RequestBody Measures measure, @PathVariable Integer measureId,
                                                  @PathVariable Integer settlementId) {
        measuresService.update(measureId, measure, settlementId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteMeasure(@PathVariable Integer id) {
        measuresService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}