package model;

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
    }

    public void documentRegistrationNo(Car car, String registrationNo){
        car.setRegistractionNo(registrationNo);
        System.out.println();
    }

    public void documentCarColour(Car car, String colour){
        car.setColour(colour);
    }

    public void checkStatus(){

    }

    public void allocateCarToSlot(){

    }

    public void vacantSlot(){

    }

    public String searchCar(Filter filter){
        return null;
    }
}
