package com.rest.domain.Service;

import com.rest.domain.Dto.SettlementsDto;
import com.rest.domain.domain.Rivers;
import com.rest.domain.domain.Settlements;

import java.util.List;

public interface RiversServiceInterface extends GeneralServiceInterface<Rivers, Integer> {
    public List<Settlements> findSettlementsByRiverId(Integer riverId);
}

