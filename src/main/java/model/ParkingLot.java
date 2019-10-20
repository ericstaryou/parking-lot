package model;

import java.util.List;

public class ParkingLot {
    private static ParkingLot parkingLotInstance;
    private int size;
    private List<Slot> slots;

    private ParkingLot(int size){
        this.size = size;
    }

    public static ParkingLot getInstance(int size){
        if(parkingLotInstance != null && parkingLotInstance.getSize() == size){
            return parkingLotInstance;
        }else{
            return new ParkingLot(size);
        }
    }

    public int getSize() {
        return size;
    }

}
