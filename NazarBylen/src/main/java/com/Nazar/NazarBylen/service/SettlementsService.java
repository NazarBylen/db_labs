package com.Nazar.NazarBylen.service;

import com.Nazar.NazarBylen.domain.Settlements;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SettlementsService {

    @Bean
    public Settlements newSettlements(String name, String gps_latitude, String gps_longtitude){
        return new Settlements(name, gps_latitude, gps_longtitude);
    }
}
