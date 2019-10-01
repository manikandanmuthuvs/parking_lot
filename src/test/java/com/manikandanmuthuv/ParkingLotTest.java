package com.manikandanmuthuv;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;


public class ParkingLotTest {

    private int numberOfSlots = 6;

    @Test
    public void CreateParkingLotWithSlots() {
        //Arrange
        String expectedParkingLot = "Created a parking lot with " + numberOfSlots + " slots";
        ParkingLot parkingLot = new ParkingLot();
        //Act
        String actualParkingLot = parkingLot.Create(numberOfSlots);
        //Assert
        assertThat(expectedParkingLot, is(actualParkingLot));
    }

    @Test
    public void allocateCarInSlot() {
        //Arrange
        ParkingLot ParkingLot = new ParkingLot();
        ParkingLot.Create(numberOfSlots);
        String regNumber = "KA-01-HH-1234";
        String color = "White";
        Car car = new Car(regNumber, color);

        //Act
        String result = ParkingLot.AllocateSlot(car);

        //Assert
        assertThat("Allocated slot number: 1", is(result));

    }
}