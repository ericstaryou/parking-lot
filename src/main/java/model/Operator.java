package model;

import java.util.List;

public interface Operator {
    void createParkingLot(int size);

    void issueTicket(String registrationNo, String colour);

    void documentRegistrationNo(Car car, String registrationNo);

    void documentCarColour(Car car, String colour);

    void checkStatus();

    void allocateCarToSlot(Car car);

    void vacantSlot(int slotNo);

    void searchCarByColour(String input, String resultType);

    void searchCarByRegistrationNo(String input);
}
