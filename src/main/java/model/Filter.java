package model;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface Filter {
    List<Slot> search(String input, List<Slot> slots);

    static List<Slot> searchByColour(String colour, List<Slot> slots){
        List<Slot> filteredSlot = slots
                .stream()
                .filter(s -> s.getCar().getColour().equalsIgnoreCase(colour))
                .collect(Collectors.toList());

        return filteredSlot;
    }

    static List<Slot> searchByRegistrationNo(String regNo, List<Slot> slots){
        List<Slot> filteredSlot = slots
                .stream()
                .filter(s -> s.getCar().getRegistrationNo().equalsIgnoreCase(regNo))
                .collect(Collectors.toList());

        return filteredSlot;
    }
}
