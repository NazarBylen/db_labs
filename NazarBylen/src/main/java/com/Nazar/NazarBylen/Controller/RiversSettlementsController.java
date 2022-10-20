package com.Nazar.NazarBylen.Controller;

import com.Nazar.NazarBylen.dao.RiversSettlementsDao;
import com.Nazar.NazarBylen.domain.RiversSettlements;
import com.Nazar.NazarBylen.service.RiversSettlementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RiversSettlementsController {

    @Autowired
    private RiversSettlementsDao rivers_s_dao;

    @Autowired
    private RiversSettlementsService rivers_s_service;

    public String showRiversSettlements() {
        List<RiversSettlements> rivers_s = rivers_s_dao.findAll();
        List<String> result = new ArrayList<>();
        rivers_s.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nriver id : " +
                    iter.getRivers_id().toString() + "\nsettlement id : " + iter.getSettlements_id().toString();
            result.add(All);
        });
        return result.toString();
    }

    public String showNewRiversSettlements(String r_id, String s_id) {
        RiversSettlements rvrs = rivers_s_service.newRiversSettlements(r_id, s_id);
        rivers_s_dao.create(rvrs);
        List<RiversSettlements> rivers_s = rivers_s_dao.findAll();
        List<String> result = new ArrayList<>();
        rivers_s.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nriver id : " +
                    iter.getRivers_id().toString() + "\nsettlement id : " + iter.getSettlements_id().toString();
            result.add(All);
        });
        return result.toString();
    }

    public String showUpdatedRiversSettlements(Integer id, String r_id, String s_id) {
        RiversSettlements rvrs = rivers_s_service.newRiversSettlements(r_id, s_id);
        rivers_s_dao.update(id, rvrs);
        List<RiversSettlements> rivers_s = rivers_s_dao.findAll();
        List<String> result = new ArrayList<>();
        rivers_s.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nriver id : " +
                    iter.getRivers_id().toString() + "\nsettlement id : " + iter.getSettlements_id().toString();
            result.add(All);
        });
        return result.toString();
    }

    public String showDeletedRiversSettlements(Integer id) {
        rivers_s_dao.delete(id);
        List<RiversSettlements> rivers_s = rivers_s_dao.findAll();
        List<String> result = new ArrayList<>();
        rivers_s.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nriver id : " +
                    iter.getRivers_id().toString() + "\nsettlement id : " + iter.getSettlements_id().toString();
            result.add(All);
        });
        return result.toString();
    }
}
