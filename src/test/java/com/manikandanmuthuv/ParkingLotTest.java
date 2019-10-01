package com.manikandanmuthuv;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;


public class ParkingLotTest {

    private int numberOfSlots = 6;
    ParkingLot parkingLot;

    @Before
    public void CreateParkingLot() {
        parkingLot = new ParkingLot();
    }
    @Test
    public void CreateParkingLotWithEmptySlots() {
        //Arrange
        String expectedParkingLot = "Created a parking lot with " + numberOfSlots + " slots";
        //Act
        String actualParkingLot = parkingLot.Create(numberOfSlots);
        //Assert
        assertThat(expectedParkingLot, is(actualParkingLot));
    }

    @Test
    public void allocateOnFirstAvailableSlot() {
        //Arrange  
        parkingLot.Create(numberOfSlots);        
        String regNumber = "KA-01-HH-1234";
        String color = "White";
        Car car = new Car(regNumber, color);
 
        //Act
        String result = parkingLot.AllocateSlot(car);

        //Assert
        assertThat("Allocated slot number: 1", is(result));

    }
    @Test
    public void allocateOnAvailableSlotNearestToEntry() {
        //Arrange
        int fromSlotNumber_2 = 2;
        int fromSlotNumber_4 = 4;
        CreateParkingLotWithCarsOnAllSlots(numberOfSlots);    
        parkingLot.LeaveSlot(fromSlotNumber_2);
        parkingLot.LeaveSlot(fromSlotNumber_4);

        String regNumber = "KA-01-HH-1234";
        String color = "White";
        Car car = new Car(regNumber, color);

        //Act
        String output = parkingLot.AllocateSlot(car);

        //Assert
        assertThat("Allocated slot number: 2", is(output));

    }

    @Test
    public void LeaveSlot() {

        //Arrange
        int fromSlotNumber = 4;
        CreateParkingLotWithCarsOnAllSlots(numberOfSlots);

        //Act
        String actual = parkingLot.LeaveSlot(fromSlotNumber);

        //Asset
        assertThat("Slot number " + fromSlotNumber + " is free", is(actual));
    }

    private void CreateParkingLotWithCarsOnAllSlots(int numberOfSlots) {
        
        parkingLot.Create(numberOfSlots);

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
     
        parkingLot.AllocateSlot(car1);
        parkingLot.AllocateSlot(car2);
        parkingLot.AllocateSlot(car3);
        parkingLot.AllocateSlot(car4);
        parkingLot.AllocateSlot(car5);
        parkingLot.AllocateSlot(car6);
    }

   
}