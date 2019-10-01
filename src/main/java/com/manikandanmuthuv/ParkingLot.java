package com.manikandanmuthuv;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Integer, Car> slot = new HashMap<>();
    private int totalSlots;
    private int totalNoOfCarsInSlots;
    
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
        if (totalNoOfCarsInSlots == totalSlots) return "Sorry, parking lot is full";
        int availableSlotNumber = getAvailableSlotNearestToEntry();
        slot.put(availableSlotNumber, car);
        // add +1 as index starts from 0
        int slotNumber = availableSlotNumber + 1;
        return "Allocated slot number: " + slotNumber; 
    }

    public String LeaveSlot(int fromSlotNumber) {
        // substract 1 to get the right slot number as index starts from 0
        if (slot.get(fromSlotNumber - 1).getRegNumber() != null) {
            slot.put(fromSlotNumber - 1, new Car());
        }
        return "Slot number " + fromSlotNumber + " is free";

    }
    public String Status() {
        String formattedText = "";
        formattedText += String.format("%10s %10s %10s\n", "Slot No.", "Registration No", "Color");
        for (int slotNumberKey = 0; slotNumberKey < slot.size(); slotNumberKey++) {
            String regNumber = null;
            if (slot.get(slotNumberKey).getRegNumber() != null) {
                regNumber = slot.get(slotNumberKey).getRegNumber();
            }
            String color = null;
            if (slot.get(slotNumberKey).getColor() != null) {
                color = slot.get(slotNumberKey).getColor();
            }
            if (regNumber != null && color != null) {
                formattedText += String.format("%10d %10s %10s\n", slotNumberKey + 1, regNumber, color);
            }
        }        
        return formattedText;       
    }
    private int getAvailableSlotNearestToEntry() {
        int slotNumber;
        for (slotNumber = 0; slotNumber < slot.size(); slotNumber++) {
            if (slot.get(slotNumber).getRegNumber() == null) {
                totalNoOfCarsInSlots += 1;
                break;
            }
        }
        return slotNumber;
    }
}