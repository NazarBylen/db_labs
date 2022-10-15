package com.Nazar.NazarBylen.view;

import com.Nazar.NazarBylen.dao.MeasuresDao;
import com.Nazar.NazarBylen.dao.RiversDao;
import com.Nazar.NazarBylen.dao.RiversSettlementsDao;
import com.Nazar.NazarBylen.dao.SettlementsDao;
import com.Nazar.NazarBylen.domain.Measures;
import com.Nazar.NazarBylen.domain.Rivers;
import com.Nazar.NazarBylen.domain.RiversSettlements;
import com.Nazar.NazarBylen.domain.Settlements;
import com.Nazar.NazarBylen.service.MeasuresService;
import com.Nazar.NazarBylen.service.RiversService;
import com.Nazar.NazarBylen.service.RiversSettlementsService;
import com.Nazar.NazarBylen.service.SettlementsService;
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
    private SettlementsDao settlementsdao;
    @Autowired
    private MeasuresDao measuresdao;
    @Autowired
    private RiversService riversservice;
    @Autowired
    private RiversSettlementsService rivers_s_service;
    @Autowired
    private SettlementsService settlementsservice;
    @Autowired
    private MeasuresService measuresservice;

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

    public void show() {
        Scanner input = new Scanner(System.in);

        System.out.println(
                """
                                1 - rivers menu
                                2 - rivers settlements menu
                                3 - settlements menu
                                4 - measures menu
                        """);
        System.out.println("Enter your choice: ");
        String choice = input.nextLine();

        if (choice.equals("1")) {
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
                    System.out.println("New Rivers List :" + showNewRivers(choiceFirstSecondName));
                    break;
                }
                case "3" -> {
                    System.out.println("Enter id and then name\n");
                    String choiceFirstThirdId = input.nextLine();
                    String choiceFirstThirdName = input.nextLine();
                    System.out.println("New Rivers List :" + showUpdatedRivers(Integer.valueOf(choiceFirstThirdId), choiceFirstThirdName));
                    break;
                }
                case "4" -> {
                    System.out.println("Enter id\n");
                    String choiceFirstFourthId = input.nextLine();
                    System.out.println("New Rivers List :" + showDeletedRivers(Integer.valueOf(choiceFirstFourthId)));
                    break;
                }
            }
        } else if (choice.equals("2")) {
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
                    System.out.println("New Rivers List :" + showNewRiversSettlements(choiceSecondSecondSId, choiceSecondSecondRId));
                    break;
                }
                case "3" -> {
                    System.out.println("Enter id, river id and then settlement id\n");
                    String choiceSecondThirdId = input.nextLine();
                    String choiceSecondThirdRId = input.nextLine();
                    String choiceSecondThirdSId = input.nextLine();
                    System.out.println("New Rivers List :" + showUpdatedRiversSettlements(Integer.valueOf(choiceSecondThirdId), choiceSecondThirdRId, choiceSecondThirdSId));
                    break;
                }
                case "4" -> {
                    System.out.println("Enter id\n");
                    String choiceSecondFourthId = input.nextLine();
                    System.out.println("New Rivers List :" + showDeletedRiversSettlements(Integer.valueOf(choiceSecondFourthId)));
                    break;
                }
            }
        } else if (choice.equals("3")) {
            System.out.println(
                    """
                                    1 - show all
                                    2 - add new settlements
                                    3 - change existing settlement
                                    4 - delete settlement
                            """);
            System.out.println("Enter your choice: ");
            String choiceThird = input.nextLine();

            switch (choiceThird) {
                case "1" -> System.out.println("Settlements :" + showSettlements());
                case "2" -> {
                    System.out.println("Enter name, gps latitude, gps longtitude\n");
                    String choiceThirdSecondName = input.nextLine();
                    String choiceThirdSecondLatitude = input.nextLine();
                    String choiceThirdSecondLongtitude = input.nextLine();
                    System.out.println("New Rivers List :" + showNewSettlements(choiceThirdSecondName, choiceThirdSecondLatitude, choiceThirdSecondLongtitude));
                    break;
                }
                case "3" -> {
                    System.out.println("Enter id, name, gps latitude, gps longtitude\n");
                    String choiceThirdThirdId = input.nextLine();
                    String choiceThirdThirdName = input.nextLine();
                    String choiceThirdThirdLatitude = input.nextLine();
                    String choiceThirdThirdLongtitude = input.nextLine();
                    System.out.println("New Rivers List :" + showUpdatedSettlements(Integer.valueOf(choiceThirdThirdId), choiceThirdThirdName, choiceThirdThirdLatitude, choiceThirdThirdLongtitude));
                    break;
                }
                case "4" -> {
                    System.out.println("Enter id\n");
                    String choiceThirdFourthId = input.nextLine();
                    System.out.println("New Rivers List :" + showDeletedSettlements(Integer.valueOf(choiceThirdFourthId)));
                    break;
                }
            }
        } else if (choice.equals("4")) {
            System.out.println(
                    """
                                    1 - show all
                                    2 - add new settlements
                                    3 - change existing settlement
                                    4 - delete settlement
                            """);
            System.out.println("Enter your choice: ");
            String choiceFourth = input.nextLine();

            switch (choiceFourth) {
                case "1" -> System.out.println("Measures :" + showMeasures());
                case "2" -> {
                    System.out.println("Enter water_level, date, settlements_id\n");
                    String choiceFourthSecondWaterLevel = input.nextLine();
                    String choiceFourthSecondDate = input.nextLine();
                    String choiceFourthSecondSettlementsId = input.nextLine();
                    System.out.println("New Rivers List :" + showNewMeasures(choiceFourthSecondWaterLevel, choiceFourthSecondDate, choiceFourthSecondSettlementsId));
                    break;
                }
                case "3" -> {
                    System.out.println("Enter id, water_level, date, settlements_id\n");
                    String choiceFourthThirdId = input.nextLine();
                    String choiceFourthThirdWaterLevel = input.nextLine();
                    String choiceFourthThirdDate = input.nextLine();
                    String choiceFourthThirdSettlementsId = input.nextLine();
                    System.out.println("New Rivers List :" + showUpdatedMeasures(Integer.valueOf(choiceFourthThirdId), choiceFourthThirdWaterLevel, choiceFourthThirdDate, choiceFourthThirdSettlementsId));
                    break;
                }
                case "4" -> {
                    System.out.println("Enter id\n");
                    String choiceFourthFourthId = input.nextLine();
                    System.out.println("New Rivers List :" + showDeletedMeasures(Integer.valueOf(choiceFourthFourthId)));
                    break;
                }
            }
        } else {
            System.out.println("No Such Option(((");
        }
        input.close();
    }
}
