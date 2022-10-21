package com.Nazar.NazarBylen.view;

import com.Nazar.NazarBylen.Controller.MeasuresController;
import com.Nazar.NazarBylen.Controller.RiversController;
import com.Nazar.NazarBylen.Controller.RiversSettlementsController;
import com.Nazar.NazarBylen.Controller.SettlementsController;
import com.Nazar.NazarBylen.dao.MeasuresDao;
import com.Nazar.NazarBylen.dao.RiversDao;
import com.Nazar.NazarBylen.dao.RiversSettlementsDao;
import com.Nazar.NazarBylen.dao.SettlementsDao;
import com.Nazar.NazarBylen.service.MeasuresService;
import com.Nazar.NazarBylen.service.RiversService;
import com.Nazar.NazarBylen.service.RiversSettlementsService;
import com.Nazar.NazarBylen.service.SettlementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class View {
    @Autowired
    private RiversController rvrscntrl;

    @Autowired
    private RiversSettlementsController rvrs_s_cntrl;
    @Autowired
    private SettlementsController stlmntscntrl;

    @Autowired
    private MeasuresController msrscntrl;

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
                case "1" -> System.out.println("Rivers :" + rvrscntrl.showRivers());
                case "2" -> {
                    System.out.println("Enter name\n");
                    String choiceFirstSecondName = input.nextLine();
                    System.out.println("New Rivers List :" + rvrscntrl.showNewRivers(choiceFirstSecondName));
                    break;
                }
                case "3" -> {
                    System.out.println("Enter id and then name\n");
                    String choiceFirstThirdId = input.nextLine();
                    String choiceFirstThirdName = input.nextLine();
                    System.out.println("New Rivers List :" + rvrscntrl.showUpdatedRivers(Integer.valueOf(choiceFirstThirdId), choiceFirstThirdName));
                    break;
                }
                case "4" -> {
                    System.out.println("Enter id\n");
                    String choiceFirstFourthId = input.nextLine();
                    System.out.println("New Rivers List :" + rvrscntrl.showDeletedRivers(Integer.valueOf(choiceFirstFourthId)));
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
                case "1" -> System.out.println("Rivers-Settlements :" + rvrs_s_cntrl.showRiversSettlements());
                case "2" -> {
                    System.out.println("Enter river id and then settlement id\n");
                    String choiceSecondSecondSId = input.nextLine();
                    String choiceSecondSecondRId = input.nextLine();
                    System.out.println("New Rivers List :" + rvrs_s_cntrl.showNewRiversSettlements(choiceSecondSecondSId, choiceSecondSecondRId));
                    break;
                }
                case "3" -> {
                    System.out.println("Enter id, river id and then settlement id\n");
                    String choiceSecondThirdId = input.nextLine();
                    String choiceSecondThirdRId = input.nextLine();
                    String choiceSecondThirdSId = input.nextLine();
                    System.out.println("New Rivers List :" + rvrs_s_cntrl.showUpdatedRiversSettlements(Integer.valueOf(choiceSecondThirdId), choiceSecondThirdRId, choiceSecondThirdSId));
                    break;
                }
                case "4" -> {
                    System.out.println("Enter id\n");
                    String choiceSecondFourthId = input.nextLine();
                    System.out.println("New Rivers List :" + rvrs_s_cntrl.showDeletedRiversSettlements(Integer.valueOf(choiceSecondFourthId)));
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
                case "1" -> System.out.println("Settlements :" + stlmntscntrl.showSettlements());
                case "2" -> {
                    System.out.println("Enter name, gps latitude, gps longtitude\n");
                    String choiceThirdSecondName = input.nextLine();
                    String choiceThirdSecondLatitude = input.nextLine();
                    String choiceThirdSecondLongtitude = input.nextLine();
                    System.out.println("New Rivers List :" + stlmntscntrl.showNewSettlements(choiceThirdSecondName, choiceThirdSecondLatitude, choiceThirdSecondLongtitude));
                    break;
                }
                case "3" -> {
                    System.out.println("Enter id, name, gps latitude, gps longtitude\n");
                    String choiceThirdThirdId = input.nextLine();
                    String choiceThirdThirdName = input.nextLine();
                    String choiceThirdThirdLatitude = input.nextLine();
                    String choiceThirdThirdLongtitude = input.nextLine();
                    System.out.println("New Rivers List :" + stlmntscntrl.showUpdatedSettlements(Integer.valueOf(choiceThirdThirdId), choiceThirdThirdName, choiceThirdThirdLatitude, choiceThirdThirdLongtitude));
                    break;
                }
                case "4" -> {
                    System.out.println("Enter id\n");
                    String choiceThirdFourthId = input.nextLine();
                    System.out.println("New Rivers List :" + stlmntscntrl.showDeletedSettlements(Integer.valueOf(choiceThirdFourthId)));
                    break;
                }
            }
        } else if (choice.equals("4")) {
            System.out.println(
                    """
                                    1 - show all
                                    2 - add new measure
                                    3 - change existing measure
                                    4 - delete measure
                            """);
            System.out.println("Enter your choice: ");
            String choiceFourth = input.nextLine();

            switch (choiceFourth) {
                case "1" -> System.out.println("Measures :" + msrscntrl.showMeasures());
                case "2" -> {
                    System.out.println("Enter water_level, date, settlements_id\n");
                    String choiceFourthSecondWaterLevel = input.nextLine();
                    String choiceFourthSecondDate = input.nextLine();
                    String choiceFourthSecondSettlementsId = input.nextLine();
                    System.out.println("New Rivers List :" + msrscntrl.showNewMeasures(choiceFourthSecondWaterLevel, choiceFourthSecondDate, choiceFourthSecondSettlementsId));
                    break;
                }
                case "3" -> {
                    System.out.println("Enter id, water_level, date, settlements_id\n");
                    String choiceFourthThirdId = input.nextLine();
                    String choiceFourthThirdWaterLevel = input.nextLine();
                    String choiceFourthThirdDate = input.nextLine();
                    String choiceFourthThirdSettlementsId = input.nextLine();
                    System.out.println("New Rivers List :" + msrscntrl.showUpdatedMeasures(Integer.valueOf(choiceFourthThirdId), choiceFourthThirdWaterLevel, choiceFourthThirdDate, choiceFourthThirdSettlementsId));
                    break;
                }
                case "4" -> {
                    System.out.println("Enter id\n");
                    String choiceFourthFourthId = input.nextLine();
                    System.out.println("New Rivers List :" + msrscntrl.showDeletedMeasures(Integer.valueOf(choiceFourthFourthId)));
                    break;
                }
            }
        } else {
            System.out.println("No Such Option(((");
        }
        input.close();
    }
}
