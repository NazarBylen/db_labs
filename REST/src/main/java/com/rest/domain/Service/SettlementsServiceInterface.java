package com.rest.domain.Service;

import com.rest.domain.domain.Measures;
import com.rest.domain.domain.Rivers;
import com.rest.domain.domain.Settlements;

import java.util.List;

public interface SettlementsServiceInterface extends GeneralServiceInterface<Settlements, Integer> {
    public List<Measures> findMeasuresBySettlementId(Integer id);
    public List<Rivers> findRiversBySettlementId(Integer id);
}

