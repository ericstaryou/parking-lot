package model;

import java.util.List;

public class OperatorImpl implements Operator {

    public void createParkingLot(int size) {
        ParkingLot carpark = ParkingLot.getInstance(size);
        System.out.println("Created a parking lot with " + carpark.getSize() + " slots");
    }

    public void issueTicket(String registrationNo, String colour) {
        this.createCarEntry(registrationNo, colour);
    }

    private void createCarEntry(String registrationNo, String colour) {
        Car car = new Car();
        documentRegistrationNo(car, registrationNo);
        documentCarColour(car, colour);
        allocateCarToSlot(car);
    }

    public void documentRegistrationNo(Car car, String registrationNo) {
        car.setRegistrationNo(registrationNo);
    }

    public void documentCarColour(Car car, String colour) {
        car.setColour(colour);
    }

    public void checkStatus() {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.printStatus();
    }

    public void allocateCarToSlot(Car car) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        if (parkingLot != null) {
            if (parkingLot.getSlots().size() < parkingLot.getSize()) {
                for (int i = 0; i < parkingLot.getSize(); i++) {
                    if (!parkingLot.getSlotMap().containsKey(i)) {
                        parkingLot.getSlots().add(new Slot(i, car));
                        parkingLot.getSlotMap().put(i, car);
                        System.out.println("Allocated slot number: " + (i + 1));
                        return;
                    }
                }
            } else {
                System.out.println("Sorry, parking lot is full");
            }
        }
    }

    public void vacantSlot(int slotNo) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.getSlotMap().remove(slotNo);
        parkingLot.getSlots().removeIf(s -> s.getSlotNo() == slotNo);
        System.out.println("Slot number " + (slotNo + 1) + " is free");
    }

    public void searchCarByColour(String input, String resultType) {
        List<Slot> filteredSlots = this.getCar(input, Filter::searchByColour);
        String output = "";
        if (filteredSlots.size() > 0) {
            for (Slot slot : filteredSlots) {
                if (resultType.equalsIgnoreCase("regNo")) {
                    if (output.isEmpty()) {
                        output = slot.getCar().getRegistrationNo();
                    } else {
                        output = output + ", " + slot.getCar().getRegistrationNo();
                    }
                } else if (resultType.equalsIgnoreCase("slotNo")) {
                    if (output.isEmpty()) {
                        output = Integer.toString(slot.getSlotNo() + 1);
                    } else {
                        output = output + ", " + (slot.getSlotNo() + 1);
                    }
                }
            }
            System.out.println(output);
        }else{
            System.out.println("Not found");
        }
    }

    public void searchCarByRegistrationNo(String input) {
        List<Slot> filteredSlots = this.getCar(input, Filter::searchByRegistrationNo);
        String output = "";
        if (filteredSlots.size() > 0) {
            for (Slot slot : filteredSlots) {
                if (output.isEmpty()) {
                    output = Integer.toString(slot.getSlotNo() + 1);
                } else {
                    output = output + ", " + (slot.getSlotNo() + 1);
                }
            }
            System.out.println(output);
        }else {
            System.out.println("Not found");
        }
    }

    private List<Slot> getCar(String input, Filter filter) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        return filter.search(input, parkingLot.getSlots());
    }
}
