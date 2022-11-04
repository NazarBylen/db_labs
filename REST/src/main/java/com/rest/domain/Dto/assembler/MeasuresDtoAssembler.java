package com.rest.domain.Dto.assembler;

import com.rest.domain.Controller.MeasuresController;
import com.rest.domain.Controller.RiversController;
import com.rest.domain.Controller.SettlementsController;
import com.rest.domain.Dto.MeasuresDto;
import com.rest.domain.Dto.RiversDto;
import com.rest.domain.Dto.SettlementsDto;
import com.rest.domain.domain.Measures;
import com.rest.domain.domain.Rivers;
import com.rest.domain.domain.Settlements;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MeasuresDtoAssembler implements RepresentationModelAssembler<Measures, MeasuresDto> {
    @Override
    public MeasuresDto toModel(Measures entity) {
        MeasuresDto measuresDto = MeasuresDto.builder()
                .id(entity.getId())
                .water_level(entity.getWater_level())
                .date(entity.getDate())
                .settlement(entity.getSettlement().getName())
                .build();
        Link selfLink = linkTo(methodOn(MeasuresController.class).getOne(measuresDto.getId())).withSelfRel();
        Link settlementsLink = linkTo(methodOn(SettlementsController.class).getOne(entity.getSettlement().getId())).withRel("settlements");
        measuresDto.add(settlementsLink);
        measuresDto.add(selfLink);
        return measuresDto;
    }

    @Override
    public CollectionModel<MeasuresDto> toCollectionModel(Iterable<? extends Measures> entities) {
        CollectionModel<MeasuresDto> measuresDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(MeasuresController.class).getAll()).withSelfRel();
        measuresDto.add(selfLink);
        return measuresDto;
    }

    public CollectionModel<MeasuresDto> toCollectionModel(Iterable<? extends Measures> entities, Link link) {
        CollectionModel<MeasuresDto> measuresDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        measuresDto.add(link);
        return measuresDto;
    }
}
