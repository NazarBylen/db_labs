package com.rest.domain.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Settlements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double gps_latitude;
    private Double gps_longtitude;

    @OneToMany(mappedBy = "settlement")
    private Set<Measures> measures;

    @ManyToMany(mappedBy = "settlements_rivers")
    Set<Rivers> rivers;

    public Settlements(String name, Double gps_latitude, Double gps_longtitude) {
        this.name = name;
        this.gps_latitude = gps_latitude;
        this.gps_longtitude = gps_longtitude;
    }
}