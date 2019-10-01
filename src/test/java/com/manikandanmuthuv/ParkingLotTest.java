package com.manikandanmuthuv;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;


public class ParkingLotTest {

    @Test
    public void CreateParkingLotWithSlots() {
        //Arrange
        int numberOfSlots = 6;
        String expectedParkingLot = "Created a parking lot with " + numberOfSlots + " slots";
        //Act
        String actualParkingLot = "";
        //Assert
        assertThat(expectedParkingLot, is(actualParkingLot));
    }
}