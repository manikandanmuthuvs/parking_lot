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

    @Test
    public void LeaveSlot() {

        //Arrange
        int fromSlotNumber = 4;
        ParkingLot ParkingLot = new ParkingLot();
        ParkingLot.Create(numberOfSlots);

        String regNumber_car1 = "KA-01-HH-1234";
        String color_car1 = "White";
        Car car1 = new Car(regNumber_car1, color_car1);

        String regNumber_car2 = "KA-01-HH-9999";
        String color_car2 = "White";
        Car car2 = new Car(regNumber_car2, color_car2);

        String regNumber_car3 = "KA-01-BB-0001";
        String color_car3 = "Black";
        Car car3 = new Car(regNumber_car3, color_car3);

        String regNumber_car4 = "KA-01-HH-7777";
        String color_car4 = "Red";
        Car car4 = new Car(regNumber_car4, color_car4);

        String regNumber_car5 = "KA-01-HH-2701";
        String color_car5 = "Blue";
        Car car5 = new Car(regNumber_car5, color_car5);

        String regNumber_car6 = "KA-01-HH-3141";
        String color_car6 = "Black";
        Car car6 = new Car(regNumber_car6, color_car6);


        ParkingLot.AllocateSlot(car1);
        ParkingLot.AllocateSlot(car2);
        ParkingLot.AllocateSlot(car3);
        ParkingLot.AllocateSlot(car4);
        ParkingLot.AllocateSlot(car5);
        ParkingLot.AllocateSlot(car6);

        //Act
        String actual = ParkingLot.LeaveSlot(fromSlotNumber);
        
        //Asset
        assertThat("Slot number " + fromSlotNumber + " is free", is(actual));

    }
}