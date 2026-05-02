package main.java.org.lld.parkinglot.model;

import main.java.org.lld.parkinglot.enums.SpotStatus;
import main.java.org.lld.parkinglot.enums.SpotType;
import main.java.org.lld.parkinglot.enums.VehicleSize;

public class ParkingSpot {

    private SpotType spotType;
    private SpotStatus spotStatus;
    private Vehicle vehicle;

    public ParkingSpot(SpotType spotType, SpotStatus spotStatus) {
        this.spotType = spotType;
        this.spotStatus = spotStatus;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return spotStatus==SpotStatus.AVAILABLE;
    }

    public boolean canFit(VehicleSize vehicleSize) {
        if (!isAvailable()) return false;

        return switch (spotType) {
            case COMPACT ->  vehicleSize == VehicleSize.SMALL;
            case REGULAR -> vehicleSize == VehicleSize.SMALL || vehicleSize == VehicleSize.MEDIUM;
            case LARGE -> vehicleSize == VehicleSize.SMALL || vehicleSize == VehicleSize.MEDIUM ||  vehicleSize == VehicleSize.LARGE;
        };
    }
}
