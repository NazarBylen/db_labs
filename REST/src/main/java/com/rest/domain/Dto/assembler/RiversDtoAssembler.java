package com.rest.domain.Dto.assembler;

import com.rest.domain.Dto.RiversDto;
import com.rest.domain.domain.Rivers;
import com.rest.domain.Controller.RiversController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RiversDtoAssembler implements RepresentationModelAssembler<Rivers, RiversDto> {
    @Override
    public RiversDto toModel(Rivers entity) {
        RiversDto riversDto = RiversDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
        Link selfLink = linkTo(methodOn(RiversController.class).getOne(riversDto.getId())).withSelfRel();
        Link getAllLink = linkTo(methodOn(RiversController.class).getAll())
                .withRel(IanaLinkRelations.COLLECTION);
        riversDto.add(selfLink);
        riversDto.add(getAllLink);
        return riversDto;
    }

    @Override
    public CollectionModel<RiversDto> toCollectionModel(Iterable<? extends Rivers> entities) {
        CollectionModel<RiversDto> bookDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(RiversController.class).getAll()).withSelfRel();
        bookDtos.add(selfLink);
        return bookDtos;
    }
}
