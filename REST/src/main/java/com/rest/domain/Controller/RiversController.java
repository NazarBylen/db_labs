package com.rest.domain.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.rest.domain.Dto.RiversDto;
import com.rest.domain.Dto.assembler.RiversDtoAssembler;
import com.rest.domain.Service.RiversService;
import com.rest.domain.domain.Rivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.Link;

import java.util.List;
import java.util.Optional;

@RestController
public class RiversController {

    @Autowired
    private final RiversService riversService;

    @Autowired
    private RiversDtoAssembler riverDtoAssembler;

    RiversController(RiversService riversService) {
        this.riversService = riversService;
    }

    @GetMapping("/rivers/{riverId}")
    public ResponseEntity<RiversDto> getOne(@PathVariable Integer riverId) {
        Rivers river = riversService.findById(riverId);
        RiversDto riverDto = riverDtoAssembler.toModel(river);
        return new ResponseEntity<>(riverDto, HttpStatus.OK);
    }

    @GetMapping("/rivers")
    public ResponseEntity<CollectionModel<RiversDto>> getAll() {
        List<Rivers> rivers = riversService.findAll();
        CollectionModel<RiversDto> cityDto = riverDtoAssembler.toCollectionModel(rivers);
        return new ResponseEntity<>(cityDto, HttpStatus.OK);
    }


//    @PostMapping("/rivers")
//    RiversDto post(@RequestBody Rivers river) {
//        return rvrs.post(river);
//    }
//
//    @PutMapping("/rivers/{id}")
//    RiversDto put(@RequestBody Rivers river, @PathVariable Integer id) {
//        return rvrs.put(river, id);
//    }
//
//    @DeleteMapping("/rivers/{id}")
//    RiversDto delete(@PathVariable Integer id) {
//        return rvrs.delete(id);
//    }
}