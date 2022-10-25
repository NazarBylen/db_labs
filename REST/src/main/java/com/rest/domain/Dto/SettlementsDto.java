package com.rest.domain.Dto;

import lombok.Data;

@Data
public class SettlementsDto {
    private Integer id;
    private String name;
    private Double gps_latitude;
    private Double gps_longtitude;
}