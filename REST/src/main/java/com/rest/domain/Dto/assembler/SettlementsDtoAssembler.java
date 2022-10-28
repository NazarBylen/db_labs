package com.rest.domain.Dto.assembler;

import com.rest.domain.Controller.RiversController;
import com.rest.domain.Controller.SettlementsController;
import com.rest.domain.Dto.SettlementsDto;
import com.rest.domain.domain.Settlements;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SettlementsDtoAssembler implements RepresentationModelAssembler<Settlements, SettlementsDto> {
    @Override
    public SettlementsDto toModel(Settlements entity) {
        SettlementsDto dto = SettlementsDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .gps_latitude(entity.getGps_latitude())
                .gps_longtitude(entity.getGps_longtitude())
                .build();
        Link selfLink = linkTo(methodOn(SettlementsController.class).getOne(dto.getId())).withSelfRel();
        Link riversLink = linkTo(methodOn(SettlementsController.class).getAllRiversForSettlement(entity.getId())).withRel("rivers");
        Link measuresLink = linkTo(methodOn(SettlementsController.class).getAllMeasuresForSettlement(entity.getId())).withRel("measures");
        dto.add(selfLink);
        dto.add(riversLink);
        dto.add(measuresLink);
        return dto;
    }

    @Override
    public CollectionModel<SettlementsDto> toCollectionModel(Iterable<? extends Settlements> entities) {
        CollectionModel<SettlementsDto> dto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(SettlementsController.class).getAll()).withSelfRel();
        dto.add(selfLink);
        return dto;
    }
    public CollectionModel<SettlementsDto> toCollectionModel(Iterable<? extends Settlements> entities, Link link) {
        CollectionModel<SettlementsDto> dto = RepresentationModelAssembler.super.toCollectionModel(entities);
        dto.add(link);
        return dto;
    }
}

