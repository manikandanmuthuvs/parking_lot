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
}