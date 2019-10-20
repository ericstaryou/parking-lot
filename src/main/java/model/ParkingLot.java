package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private static ParkingLot parkingLotInstance;
    private int size;
    private List<Slot> slots;
    private HashMap<Integer, Car> slotMap;

    private ParkingLot(int size){
        this.size = size;
        this.slots = new ArrayList<>();
        this.slotMap = new HashMap<>();
    }

    public static ParkingLot getInstance(int size){
        if(parkingLotInstance != null && parkingLotInstance.getSize() == size){
            return parkingLotInstance;
        }else{
            parkingLotInstance = new ParkingLot(size);
            return parkingLotInstance;
        }
    }

    public static ParkingLot getInstance(){
        return parkingLotInstance;
    }

    public int getSize() {
        return size;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public HashMap<Integer, Car> getSlotMap() {
        return slotMap;
    }

    public void printStatus(){
        System.out.println("Slot No.    Registration No     Colour");
        for (Slot slot :slots) {
            System.out.println((slot.getSlotNo()+1) + "     " + slot.getCar().getRegistractionNo() + "      " + slot.getCar().getColour());
        }
    }

}
