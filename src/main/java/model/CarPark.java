package model;

import java.util.List;

public class CarPark {
    private static CarPark carParkInstance;
    private int size;
    private List<Slot> slots;

    private CarPark(){

    }

    public static CarPark getInstance(){
        if(carParkInstance != null){
            return carParkInstance;
        }else{
            return new CarPark();
        }
    }

    public void checkStatus(){

    }

    public void allocateCarToSlot(){

    }

    public void vacantSlot(){

    }

}
