package com.rest.domain.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class MeasuresDto {
    private Integer id;
    private String water_level;
    private Date date;
    private Integer settlements_id;
}