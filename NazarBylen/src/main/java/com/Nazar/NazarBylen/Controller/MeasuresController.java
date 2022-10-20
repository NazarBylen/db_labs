package com.Nazar.NazarBylen.Controller;

import com.Nazar.NazarBylen.dao.MeasuresDao;
import com.Nazar.NazarBylen.domain.Measures;
import com.Nazar.NazarBylen.service.MeasuresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MeasuresController {

    @Autowired
    private MeasuresDao measuresdao;

    @Autowired
    private MeasuresService measuresservice;

    public String showMeasures() {
        List<Measures> measures = measuresdao.findAll();
        List<String> result = new ArrayList<>();
        measures.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nWater Level : " +
                    iter.getWater_level().toString() + "\nDate : " + iter.getDate().toString() + "\nSettlement id : " + iter.getSettlements_id().toString();
            result.add(All);
        });
        return result.toString();
    }

    public String showNewMeasures(String water_level, String date, String settlements_id) {
        Measures msrs = measuresservice.newMeasures(water_level, date, settlements_id);
        measuresdao.create(msrs);
        List<Measures> measures = measuresdao.findAll();
        List<String> result = new ArrayList<>();
        measures.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nWater Level : " +
                    iter.getWater_level().toString() + "\nDate : " + iter.getDate().toString() + "\nSettlement id : " + iter.getSettlements_id().toString();
            result.add(All);
        });
        return result.toString();
    }

    public String showUpdatedMeasures(Integer id, String water_level, String date, String settlements_id) {
        Measures msrs = measuresservice.newMeasures(water_level, date, settlements_id);
        measuresdao.update(id, msrs);
        List<Measures> measures = measuresdao.findAll();
        List<String> result = new ArrayList<>();
        measures.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nWater Level : " +
                    iter.getWater_level().toString() + "\nDate : " + iter.getDate().toString() + "\nSettlement id : " + iter.getSettlements_id().toString();
            result.add(All);
        });
        return result.toString();
    }

    public String showDeletedMeasures(Integer id) {
        measuresdao.delete(id);
        List<Measures> measures = measuresdao.findAll();
        List<String> result = new ArrayList<>();
        measures.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nWater Level : " +
                    iter.getWater_level().toString() + "\nDate : " + iter.getDate().toString() + "\nSettlement id : " + iter.getSettlements_id().toString();
            result.add(All);
        });
        return result.toString();
    }
}
