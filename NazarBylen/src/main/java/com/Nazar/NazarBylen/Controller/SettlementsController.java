package com.Nazar.NazarBylen.Controller;

import com.Nazar.NazarBylen.dao.SettlementsDao;
import com.Nazar.NazarBylen.domain.Settlements;
import com.Nazar.NazarBylen.service.SettlementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SettlementsController {

    @Autowired
    private SettlementsDao settlementsdao;

    @Autowired
    private SettlementsService settlementsservice;

    public String showSettlements() {
        List<Settlements> settlements = settlementsdao.findAll();
        List<String> result = new ArrayList<>();
        settlements.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nname : " +
                    iter.getName().toString() + "\nGps latitude : " + iter.getGps_latitude().toString() + "\nGps longtitude : " + iter.getGps_longtitude().toString();
            result.add(All);
        });
        return result.toString();
    }

    public String showNewSettlements(String name, String latitude, String longtitude) {
        Settlements stlmnts = settlementsservice.newSettlements(name, latitude, longtitude);
        settlementsdao.create(stlmnts);
        List<Settlements> settlements = settlementsdao.findAll();
        List<String> result = new ArrayList<>();
        settlements.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nname : " +
                    iter.getName().toString() + "\nGps latitude : " + iter.getGps_latitude().toString() + "\nGps longtitude : " + iter.getGps_longtitude().toString();
            result.add(All);
        });
        return result.toString();
    }

    public String showUpdatedSettlements(Integer id, String name, String latitude, String longtitude) {
        Settlements stlmnts = settlementsservice.newSettlements(name, latitude, longtitude);
        settlementsdao.update(id, stlmnts);
        List<Settlements> settlements = settlementsdao.findAll();
        List<String> result = new ArrayList<>();
        settlements.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nname : " +
                    iter.getName().toString() + "\nGps latitude : " + iter.getGps_latitude().toString() + "\nGps longtitude : " + iter.getGps_longtitude().toString();
            result.add(All);
        });
        return result.toString();
    }

    public String showDeletedSettlements(Integer id) {
        settlementsdao.delete(id);
        List<Settlements> settlements = settlementsdao.findAll();
        List<String> result = new ArrayList<>();
        settlements.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nname : " +
                    iter.getName().toString() + "\nGps latitude : " + iter.getGps_latitude().toString() + "\nGps longtitude : " + iter.getGps_longtitude().toString();
            result.add(All);
        });
        return result.toString();
    }
}
