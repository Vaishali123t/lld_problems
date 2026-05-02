package main.java.org.lld.parkinglot.strategy.parking;

import main.java.org.lld.parkinglot.enums.VehicleSize;
import main.java.org.lld.parkinglot.model.ParkingFloor;
import main.java.org.lld.parkinglot.model.ParkingSpot;

import java.util.List;

public interface IParkingStrategy {

    ParkingSpot findParkingSpot(VehicleSize vehicleSize, List<ParkingFloor> parkingFloors);

}
