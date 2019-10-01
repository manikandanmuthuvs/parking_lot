package com.manikandanmuthuv;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Integer, Car> slot = new HashMap<>();
    private int totalSlots;

    public ParkingLot() {
    }

    public String Create(int numberOfSlots) {
        for (int i = 0; i < numberOfSlots; i++) {
            slot.put(i, new Car());
        }
        totalSlots = slot.size();
        return "Created a parking lot with " + totalSlots + " slots";
    }

    public String AllocateSlot(Car car) {
        int availableSlotNumber = 0;

        for (int slotNumberKey = 0; slotNumberKey < slot.size(); slotNumberKey++) {
            if (slot.get(slotNumberKey).getRegNumber() == null) {
                // add 1 to get the right slot number as index starts from 0
                availableSlotNumber = slotNumberKey + 1;
                slot.put(slotNumberKey, car);
                break;
            }
        }
        return "Allocated slot number: " + availableSlotNumber;
    }

    public String LeaveSlot(int fromSlotNumber) {
        // substract 1 to get the right slot number as index starts from 0
        if (slot.get(fromSlotNumber - 1).getRegNumber() != null) {
            slot.put(fromSlotNumber - 1, new Car());
        }
        return "Slot number " + fromSlotNumber + " is free";

    }
}