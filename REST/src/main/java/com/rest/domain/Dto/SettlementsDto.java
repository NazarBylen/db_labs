package com.rest.domain.Dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Builder
@Data
public class SettlementsDto extends RepresentationModel<SettlementsDto> {
    private Integer id;
    private String name;
    private Double gps_latitude;
    private Double gps_longtitude;
}