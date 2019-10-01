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
        int availableSlotNumber = getAvailableSlotNearestToEntry();
        slot.put(availableSlotNumber, car);
        int slotNumber = availableSlotNumber + 1;
        // add +1 as index starts from 0
        return "Allocated slot number: " + slotNumber; 
    }

    public String LeaveSlot(int fromSlotNumber) {
        // substract 1 to get the right slot number as index starts from 0
        if (slot.get(fromSlotNumber - 1).getRegNumber() != null) {
            slot.put(fromSlotNumber - 1, new Car());
        }
        return "Slot number " + fromSlotNumber + " is free";

    }

    private int getAvailableSlotNearestToEntry() {
        int slotNumber;
        for (slotNumber = 0; slotNumber < slot.size(); slotNumber++) {
            if (slot.get(slotNumber).getRegNumber() == null) {
                break;
            }
        }
        return slotNumber;
    }
}