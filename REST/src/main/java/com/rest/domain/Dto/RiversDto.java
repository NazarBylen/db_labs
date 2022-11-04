package com.rest.domain.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.domain.Service.RiversService;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "river", collectionRelation = "rivers")
public class RiversDto extends RepresentationModel<RiversDto> {
    private Integer id;
    private String name;
}