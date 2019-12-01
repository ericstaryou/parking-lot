import model.*;
import java.io.File;
import java.io.FileNotFoundException;
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
    final static String FILE_INPUT = "file_input.txt";

    public static void main(String args[]) throws FileNotFoundException {

        Operator operator = new OperatorImpl();
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Welcome to ABC Parking Lot, please key in a command: ");

        boolean terminate = false;
        while (!terminate){
            String command = args[0];
            if (run(command, operator)) {
                terminate = true;
            }
        }
    }

    public static boolean run(String command, Operator operator) throws FileNotFoundException{
        if(command.startsWith(CREATE_PARKING_LOT)){
            int carParkSize = Integer.parseInt(command.substring(CREATE_PARKING_LOT.length()).trim());
            operator.createParkingLot(carParkSize);
        }else if(command.startsWith(PARK)){
            String[] input = command.split("\\s");
            operator.issueTicket(input[1], input[2]);
        }else if(command.startsWith(LEAVE)){
            String[] input = command.split("\\s");
            operator.vacantSlot(Integer.parseInt(input[1])-1);
        }else if(command.startsWith(STATUS)){
            operator.checkStatus();
        }else if(command.startsWith(REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR)){
            String[] input = command.split("\\s");
            operator.searchCarByColour(input[1], "regNo");
        }else if(command.startsWith(SLOT_NUMBERS_FOR_CARS_WITH_COLOUR)){
            String[] input = command.split("\\s");
            operator.searchCarByColour(input[1], "slotNo");
        }else if(command.startsWith(SLOT_NUMBER_FOR_REGISTRATION_NUMBER)){
            String[] input = command.split("\\s");
            operator.searchCarByRegistrationNo(input[1]);
        }else if(command.startsWith(EXIT)){
            return true;
        }else if(command.endsWith(FILE_INPUT)){
            Scanner fileScanner = new Scanner(new File(command));
            boolean terminate = false;
            while (fileScanner.hasNextLine()){
                if(!terminate){
                    terminate = run(fileScanner.nextLine(), operator);
                }
            }
        }
        return false;
    }
}
