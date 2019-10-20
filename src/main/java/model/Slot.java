package model;

public class Slot {

    private int slotNo;
    private Car car;

    public Slot(int slotNo, Car car){
        this.slotNo = slotNo;
        this.car = car;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public Car getCar() {
        return car;
    }
}
