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
public class RiversSettlements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rivers_id;
    private String settlements_id;

    public RiversSettlements(String rivers_id, String settlements_id) {
        this.rivers_id = rivers_id;
        this.settlements_id = settlements_id;
    }
}