package model;

import java.util.HashMap;

public class OperatorImpl implements Operator {

    public void createParkingLot(int size){
        ParkingLot carpark = ParkingLot.getInstance(size);
        System.out.println("Created a parking lot with " + carpark.getSize() + " slots");
    }

    public void issueTicket(String registrationNo, String colour){
        this.createCarEntry(registrationNo, colour);
    }

    private void createCarEntry(String registrationNo, String colour){
        Car car = new Car();
        documentRegistrationNo(car, registrationNo);
        documentCarColour(car, colour);
        allocateCarToSlot(car);
    }

    public void documentRegistrationNo(Car car, String registrationNo){
        car.setRegistractionNo(registrationNo);
        System.out.println();
    }

    public void documentCarColour(Car car, String colour){
        car.setColour(colour);
    }

    public void checkStatus(){
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.printStatus();
    }

    public void allocateCarToSlot(Car car){
        ParkingLot parkingLot = ParkingLot.getInstance();
        if(parkingLot != null){
            if(parkingLot.getSlots().size() < parkingLot.getSize()){
                for (int i = 0; i < parkingLot.getSize(); i++ ){
                    if(!parkingLot.getSlotMap().containsKey(i)){
                        parkingLot.getSlots().add(new Slot(i, car));
                        parkingLot.getSlotMap().put(i, car);
                        System.out.println("Allocated slot number: " + (i+1));
                        return;
                    }
                }
            }else{
                System.out.println("Sorry, parking lot is full");
            }
        }
    }

    public void vacantSlot(int slotNo){
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.getSlotMap().remove(slotNo);
        parkingLot.getSlots().removeIf(s->s.getSlotNo() == slotNo);
        System.out.println("Slot number " + (slotNo+1) +" is free");
    }

    public String searchCar(Filter filter){
        return null;
    }
}
