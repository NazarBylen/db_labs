package com.rest.domain.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.domain.domain.Settlements;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Date;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "measure", collectionRelation = "measures")
public class MeasuresDto extends RepresentationModel<MeasuresDto>{
    private Integer id;
    private String water_level;
    private Date date;
    private String settlement;
}