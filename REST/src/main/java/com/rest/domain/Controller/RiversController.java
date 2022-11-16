package com.rest.domain.Controller;

import com.rest.domain.Dto.RiversDto;
import com.rest.domain.Dto.SettlementsDto;
import com.rest.domain.Dto.assembler.RiversDtoAssembler;
import com.rest.domain.Dto.assembler.SettlementsDtoAssembler;
import com.rest.domain.Service.RiversService;
import com.rest.domain.domain.Rivers;
import com.rest.domain.domain.Settlements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/rivers")
public class RiversController {

    @Autowired
    private final RiversService riversService;

    @Autowired
    private RiversDtoAssembler riversDtoAssembler;
    @Autowired
    private SettlementsDtoAssembler settlementsDtoAssembler;

    RiversController(RiversService riversService) {
        this.riversService = riversService;
    }

    @GetMapping("/{riverId}")
    public ResponseEntity<RiversDto> getOne(@PathVariable Integer riverId) {
        Rivers river = riversService.findById(riverId);
        RiversDto riverDto = riversDtoAssembler.toModel(river);
        return new ResponseEntity<>(riverDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<RiversDto>> getAll() {
        List<Rivers> rivers = riversService.findAll();
        CollectionModel<RiversDto> riverDto = riversDtoAssembler.toCollectionModel(rivers);
        return new ResponseEntity<>(riverDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<RiversDto> addRiver(@RequestBody Rivers river) {
        Rivers newRiver = riversService.create(river);
        RiversDto riverDto = riversDtoAssembler.toModel(newRiver);
        return new ResponseEntity<>(riverDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/withProcedure")
    public ResponseEntity<RiversDto> addRiverWithProcedure(@RequestBody Rivers river) {
        Rivers newRiver = riversService.createWithProcedure(river);
        RiversDto riverDto = riversDtoAssembler.toModel(newRiver);
        return new ResponseEntity<>(riverDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{riverId}")
    public ResponseEntity<?> updateRiver(@RequestBody Rivers river, @PathVariable Integer riverId) {
        riversService.update(riverId, river);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{riverId}")
    public ResponseEntity<?> deleteRiver(@PathVariable Integer riverId) {
        riversService.delete(riverId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{riverId}/settlements")
    public ResponseEntity<CollectionModel<SettlementsDto>> getAllSettlementsForRiver(@PathVariable Integer riverId) {
        List<Settlements> settlements = riversService.findSettlementsByRiverId(riverId);
        Link selfLink = linkTo(methodOn(RiversController.class).getAllSettlementsForRiver(riverId)).withSelfRel();
        CollectionModel<SettlementsDto> dto = settlementsDtoAssembler.toCollectionModel(settlements, selfLink);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}