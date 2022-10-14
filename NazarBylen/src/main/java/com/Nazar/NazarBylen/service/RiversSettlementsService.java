package com.Nazar.NazarBylen.service;

import com.Nazar.NazarBylen.domain.RiversSettlements;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RiversSettlementsService {

    @Bean
    public RiversSettlements newRiversSettlements(String rId, String sId){
        return new RiversSettlements(rId, sId);
    }
}
