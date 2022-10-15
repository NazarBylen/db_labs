package com.Nazar.NazarBylen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Measures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String water_level;
    private String date;
    private String settlements_id;

    public Measures(String water_level, String date, String settlements_id) {
        this.water_level = water_level;
        this.date = date;
        this.settlements_id = settlements_id;
    }
}