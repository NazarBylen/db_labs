package com.Nazar.NazarBylen.service;

import com.Nazar.NazarBylen.domain.Measures;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MeasuresService {

    @Bean
    public Measures newMeasures(String water_level, String date, String settlements_id){
        return new Measures(water_level, date, settlements_id);
    }
}
