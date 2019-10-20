package model;

public interface Operator {
    void createParkingLot(int size);

    void issueTicket(String registrationNo, String colour);

    void documentRegistrationNo(Car car, String registrationNo);

    void documentCarColour(Car car, String colour);

    void checkStatus();

    void allocateCarToSlot(Car car);

    void vacantSlot(int slotNo);

    String searchCar(Filter filter);
}
