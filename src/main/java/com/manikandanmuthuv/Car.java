package com.manikandanmuthuv;

public class Car {
    private String RegNumber;
    private String Color;

    public Car() {
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
    }

    public String getRegNumber() {
        return RegNumber;
    }

    public void setRegNumber(String regNumber) {
        this.RegNumber = regNumber;
    }

    public Car(String RegNumber, String Color) {
        this.setRegNumber(RegNumber);
        this.setColor(Color);
    }
}