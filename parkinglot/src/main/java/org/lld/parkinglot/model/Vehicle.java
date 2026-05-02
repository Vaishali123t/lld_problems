package main.java.org.lld.parkinglot.model;

import main.java.org.lld.parkinglot.enums.VehicleSize;

public abstract class Vehicle {

    private String licenseNumber;
    private String color;
    private VehicleSize vehicleSize;

    public Vehicle(String licenseNumber, String color, VehicleSize vehicleSize) {
        this.licenseNumber = licenseNumber;
        this.color = color;
        this.vehicleSize = vehicleSize;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
    }
}
