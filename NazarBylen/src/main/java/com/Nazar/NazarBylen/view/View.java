package com.Nazar.NazarBylen.view;

import com.Nazar.NazarBylen.dao.RiversDao;
import com.Nazar.NazarBylen.dao.RiversSettlementsDao;
import com.Nazar.NazarBylen.domain.Rivers;
import com.Nazar.NazarBylen.domain.RiversSettlements;
import com.Nazar.NazarBylen.service.RiversService;
import com.Nazar.NazarBylen.service.RiversSettlementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
public class View {
    @Autowired
    private RiversDao riversdao;
    @Autowired
    private RiversSettlementsDao rivers_s_dao;
    @Autowired
    private RiversService riversservice;
    @Autowired
    private RiversSettlementsService rivers_s_service;

    @Bean
    public String showRivers(){
        List <Rivers> rivers= riversdao.findAll();
        List <String> result = new ArrayList<>();
        rivers.forEach((iter)->{
            String All = "\nid : " + iter.getId().toString() + "\nname : " + iter.getName();
            result.add(All);
        });
        return result.toString();
    }

    public String showNewRivers(String name){
        Rivers rvrs = riversservice.newRivers(name);
        riversdao.create(rvrs);
        List <Rivers> rivers= riversdao.findAll();
        List <String> result = new ArrayList<>();
        rivers.forEach((iter)->{
            String All = "\nid : " + iter.getId().toString() + "\nname : " + iter.getName();
            result.add(All);
        });
        return result.toString();
    }

    public String showUpdatedRivers(Integer id, String name){
        Rivers rvrs = riversservice.newRivers(name);
        riversdao.update(id, rvrs);
        List <Rivers> rivers= riversdao.findAll();
        List <String> result = new ArrayList<>();
        rivers.forEach((iter)->{
            String All = "\nid : " + iter.getId().toString() + "\nname : " + iter.getName();
            result.add(All);
        });
        return result.toString();
    }

    public String showDeletedRivers(Integer id){
        riversdao.delete(id);
        List <Rivers> rivers= riversdao.findAll();
        List <String> result = new ArrayList<>();
        rivers.forEach((iter)->{
            String All = "\nid : " + iter.getId().toString() + "\nname : " + iter.getName();
            result.add(All);
        });
        return result.toString();
    }

    public String showRiversSettlements(){
        List <RiversSettlements> rivers_s = rivers_s_dao.findAll();
        List <String> result = new ArrayList<>();
        rivers_s.forEach((iter)->{
            String All = "\nid : " + iter.getId().toString() + "\nriver id : " +
                    iter.getRivers_id().toString() + "\nsettlement id : " + iter.getSettlements_id().toString();
            result.add(All);
        });
        return result.toString();
    }

    public String showNewRiversSettlements(String r_id, String s_id){
        RiversSettlements rvrs = rivers_s_service.newRiversSettlements(r_id, s_id);
        rivers_s_dao.create(rvrs);
        List <RiversSettlements> rivers_s = rivers_s_dao.findAll();
        List <String> result = new ArrayList<>();
        rivers_s.forEach((iter)->{
            String All = "\nid : " + iter.getId().toString() + "\nriver id : " +
                    iter.getRivers_id().toString() + "\nsettlement id : " + iter.getSettlements_id().toString();
            result.add(All);
        });
        return result.toString();
    }

    public void show() {
        Scanner input = new Scanner(System.in);

        System.out.println(
                """
                        1 - rivers menu
                        2 - rivers settlements menu
                        3 - settlements men
                        4 - measures menu
                """);
        System.out.println("Enter your choice: ");
        String choice = input.nextLine();

        if(choice.equals("1")){
            System.out.println(
                    """
                            1 - show all
                            2 - add new river
                            3 - change existing river
                            4 - delete river
                    """);
            System.out.println("Enter your choice: ");
            String choiceFirst = input.nextLine();

            switch (choiceFirst) {
                case "1" -> System.out.println("Rivers :" + showRivers());
                case "2" -> {
                    System.out.println("Enter name\n");
                    String choiceFirstSecondName = input.nextLine();
                    System.out.println("New Rivers List :"+showNewRivers(choiceFirstSecondName));
                    break;
                }
                case "3" -> {
                    System.out.println("Enter id and then name\n");
                    String choiceFirstThirdId = input.nextLine();
                    String choiceFirstThirdName = input.nextLine();
                    System.out.println("New Rivers List :"+showUpdatedRivers(Integer.valueOf(choiceFirstThirdId), choiceFirstThirdName) );
                    break;
                }
                case "4" -> {
                    System.out.println("Enter id\n");
                    String choiceFirstFourthId = input.nextLine();
                    System.out.println("New Rivers List :" + showDeletedRivers(Integer.valueOf(choiceFirstFourthId)));
                    break;
                }
            }
        } else if(choice.equals("2")) {
            System.out.println(
                    """
                                    1 - show all
                                    2 - add new river-settlement relation
                                    3 - change existing river-settlement relation
                                    4 - delete river-settlement relation
                            """);
            System.out.println("Enter your choice: ");
            String choiceSecond = input.nextLine();

            switch (choiceSecond) {
                case "1" -> System.out.println("Rivers-Settlements :" + showRiversSettlements());
                case "2" -> {
                    System.out.println("Enter river id and then settlement id\n");
                    String choiceSecondSecondSId = input.nextLine();
                    String choiceSecondSecondRId = input.nextLine();
                    System.out.println("New Rivers List :"+showNewRiversSettlements(choiceSecondSecondSId, choiceSecondSecondRId));
                    break;
                }
            }
        }
        input.close();
    }
}
