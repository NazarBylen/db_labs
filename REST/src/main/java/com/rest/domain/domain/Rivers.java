package com.rest.domain.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest.domain.Dto.RiversDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(
            name="rivers_settlements",
            joinColumns = @JoinColumn(name="rivers_id"),
            inverseJoinColumns = @JoinColumn(name="settlements_id")
    )
    @JsonIgnore
    Set<Settlements> settlements_rivers;

    public Rivers(String name) {
        this.name=name;
    }
}
