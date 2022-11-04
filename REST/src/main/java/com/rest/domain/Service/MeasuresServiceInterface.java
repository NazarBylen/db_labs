package com.rest.domain.Service;

import com.rest.domain.domain.Measures;

public interface MeasuresServiceInterface extends GeneralServiceInterface<Measures, Integer> {
    Measures create(Measures entity, Integer settlementId);

    void update(Integer measureId, Measures entity, Integer settlementId);
}