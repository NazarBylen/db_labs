package com.rest.domain.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Measures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String water_level;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "settlements_id")
    @JsonIgnore
    private Settlements settlements_id;

    public Measures(String water_level, Date date) {
        this.water_level = water_level;
        this.date = date;
    }
}