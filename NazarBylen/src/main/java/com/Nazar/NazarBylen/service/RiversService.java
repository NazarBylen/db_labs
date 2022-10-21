package com.Nazar.NazarBylen.service;

import com.Nazar.NazarBylen.domain.Rivers;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RiversService {

    @Bean
    public Rivers newRivers(String name){
        return new Rivers(name);
    }
}
