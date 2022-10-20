package com.Nazar.NazarBylen.Controller;

import com.Nazar.NazarBylen.dao.RiversDao;
import com.Nazar.NazarBylen.domain.Rivers;
import com.Nazar.NazarBylen.service.RiversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RiversController{

    @Autowired
    private RiversDao riversdao;

    @Autowired
    private RiversService riversservice;

    @Bean
    public String showRivers() {
        List<Rivers> rivers = riversdao.findAll();
        List<String> result = new ArrayList<>();
        rivers.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nname : " + iter.getName();
            result.add(All);
        });
        return result.toString();
    }

    public String showNewRivers(String name) {
        Rivers rvrs = riversservice.newRivers(name);
        riversdao.create(rvrs);
        List<Rivers> rivers = riversdao.findAll();
        List<String> result = new ArrayList<>();
        rivers.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nname : " + iter.getName();
            result.add(All);
        });
        return result.toString();
    }

    public String showUpdatedRivers(Integer id, String name) {
        Rivers rvrs = riversservice.newRivers(name);
        riversdao.update(id, rvrs);
        List<Rivers> rivers = riversdao.findAll();
        List<String> result = new ArrayList<>();
        rivers.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nname : " + iter.getName();
            result.add(All);
        });
        return result.toString();
    }

    public String showDeletedRivers(Integer id) {
        riversdao.delete(id);
        List<Rivers> rivers = riversdao.findAll();
        List<String> result = new ArrayList<>();
        rivers.forEach((iter) -> {
            String All = "\nid : " + iter.getId().toString() + "\nname : " + iter.getName();
            result.add(All);
        });
        return result.toString();
    }
}
