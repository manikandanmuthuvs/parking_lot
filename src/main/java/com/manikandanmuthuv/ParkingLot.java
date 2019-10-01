package com.manikandanmuthuv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public String FindRegNumbersOfAllCarsByItsColor(String color) {
        List<String> cars = new ArrayList<String>();
        for (int slotNumberKey = 0; slotNumberKey < slot.size(); slotNumberKey++) {
            try {
                if (slot.get(slotNumberKey).getColor().equals(color)) {     
                    cars.add(slot.get(slotNumberKey).getRegNumber());                
                } 
            } catch (Exception e) {
            }                                   
        }
        return String.join(",",cars);
    }
    public String FindAllSlotNumbersByCarColor(String color) {
        List<String> cars = new ArrayList<String>();
        for (int slotNumberKey = 0; slotNumberKey < slot.size(); slotNumberKey++) {
            try {
                if (slot.get(slotNumberKey).getColor().equals(color)) {
                    cars.add(String.valueOf(slotNumberKey + 1));             
                }  
            } catch (Exception e) {
            }
                                  
        }
        return String.join(",", cars);
    }
    public String FindAllSlotNumbersByCarRegNo(String regNumber) {
        List<String> cars = new ArrayList<String>();
        for (int slotNumberKey = 0; slotNumberKey < slot.size(); slotNumberKey++) {
            try {
                if (slot.get(slotNumberKey).getRegNumber().equals(regNumber)) {
                    cars.add(String.valueOf(slotNumberKey + 1));             
                }
            } catch (Exception e) {
            }
            
        }
        if (cars.size() == 0) cars.add("Not found");
        return String.join(",",cars);
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