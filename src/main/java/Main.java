import model.*;
import utilities.Reader;

import java.util.*;

public class Main {
    final static String CREATE_PARKING_LOT = "create_parking_lot";
    final static String PARK = "park";
    final static String LEAVE = "leave";
    final static String STATUS = "status";
    final static String REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR = "registration_numbers_for_cars_with_colour";
    final static String SLOT_NUMBERS_FOR_CARS_WITH_COLOUR = "slot_numbers_for_cars_with_colour";
    final static String SLOT_NUMBER_FOR_REGISTRATION_NUMBER = "slot_number_for_registration_number";
    final static String EXIT = "exit";


    public static void main(String args[]){
        Operator operator = new OperatorImpl();
        System.out.println("Welcome to ABC Parking Lot, please key in a command: ");
        while (true){
            Scanner s = new Scanner(System.in);
            String command = s.nextLine();

            if(command.startsWith(CREATE_PARKING_LOT)){
                int carParkSize = Integer.parseInt(command.substring(CREATE_PARKING_LOT.length()).trim());
                operator.createParkingLot(carParkSize);
            }else if(command.startsWith(PARK)){ //park KA-01-HH-1234 White
                String[] input = command.split("\\s");
                operator.issueTicket(input[1], input[2]);
            }else if(command.startsWith(LEAVE)){ //leave 4
                String[] input = command.split("\\s");
                operator.vacantSlot(Integer.parseInt(input[1])-1);
            }else if(command.startsWith(STATUS)){
                operator.checkStatus();
            }else if(command.startsWith(REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR)){

            }else if(command.startsWith(SLOT_NUMBERS_FOR_CARS_WITH_COLOUR)){

            }else if(command.startsWith(SLOT_NUMBER_FOR_REGISTRATION_NUMBER)){

            }else if(command.startsWith(EXIT)){
                break;
            }
        }
    }
}
