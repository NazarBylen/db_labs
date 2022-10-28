package com.rest.domain.Controller;

import com.rest.domain.Dto.MeasuresDto;
import com.rest.domain.Dto.RiversDto;
import com.rest.domain.Dto.SettlementsDto;
import com.rest.domain.Dto.assembler.MeasuresDtoAssembler;
import com.rest.domain.Dto.assembler.RiversDtoAssembler;
import com.rest.domain.Dto.assembler.SettlementsDtoAssembler;
import com.rest.domain.Service.SettlementsService;
import com.rest.domain.domain.Measures;
import com.rest.domain.domain.Rivers;
import com.rest.domain.domain.Settlements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/settlements")
public class SettlementsController {
    @Autowired
    private SettlementsService settlementsService;

    @Autowired
    private SettlementsDtoAssembler settlementsDtoAssembler;
    @Autowired
    private MeasuresDtoAssembler measuresDtoAssembler;
    @Autowired
    private RiversDtoAssembler riversDtoAssembler;

    SettlementsController(SettlementsService settlementsService) {
        this.settlementsService = settlementsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SettlementsDto> getOne(@PathVariable Integer id) {
        Settlements settlement = settlementsService.findById(id);
        SettlementsDto dto = settlementsDtoAssembler.toModel(settlement);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<SettlementsDto>> getAll() {
        List<Settlements> rivers = settlementsService.findAll();
        CollectionModel<SettlementsDto> dto = settlementsDtoAssembler.toCollectionModel(rivers);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/measures")
    public ResponseEntity<CollectionModel<MeasuresDto>> getAllMeasuresForSettlement(@PathVariable Integer id) {
        List<Measures> measures = settlementsService.findMeasuresBySettlementId(id);
        Link selfLink = linkTo(methodOn(SettlementsController.class).getAllMeasuresForSettlement(id)).withSelfRel();
        CollectionModel<MeasuresDto> dto = measuresDtoAssembler.toCollectionModel(measures, selfLink);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @GetMapping("/{id}/rivers")
    public ResponseEntity<CollectionModel<RiversDto>> getAllRiversForSettlement(@PathVariable Integer id) {
        List<Rivers> rivers = settlementsService.findRiversBySettlementId(id);
        Link selfLink = linkTo(methodOn(SettlementsController.class).getAllRiversForSettlement(id)).withSelfRel();
        CollectionModel<RiversDto> dto = riversDtoAssembler.toCollectionModel(rivers, selfLink);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<SettlementsDto> addSettlement(@RequestBody Settlements settlement) {
        Settlements newSettlement = settlementsService.create(settlement);
        SettlementsDto settlementsDto = settlementsDtoAssembler.toModel(newSettlement);
        return new ResponseEntity<>(settlementsDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateSettlement(@RequestBody Settlements settlement, @PathVariable Integer id) {
        settlementsService.update(id, settlement);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteSettlement(@PathVariable Integer id) {
        settlementsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}