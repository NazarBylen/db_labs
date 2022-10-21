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
public class Settlements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String gps_latitude;
    private String gps_longtitude;

    public Settlements(String name, String gps_latitude, String gps_longtitude) {
        this.name = name;
        this.gps_latitude = gps_latitude;
        this.gps_longtitude = gps_longtitude;
    }
}