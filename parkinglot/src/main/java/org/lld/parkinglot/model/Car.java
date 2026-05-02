package main.java.org.lld.parkinglot.model;

import main.java.org.lld.parkinglot.enums.VehicleSize;

public class Car extends Vehicle{

    public Car(String licenseNumber, String color, VehicleSize vehicleSize) {
        super(licenseNumber, color, vehicleSize);
    }
}
