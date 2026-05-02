package main.java.org.lld.parkinglot.strategy.parking;

import main.java.org.lld.parkinglot.enums.VehicleSize;
import main.java.org.lld.parkinglot.model.ParkingFloor;
import main.java.org.lld.parkinglot.model.ParkingSpot;

import java.util.List;

public class NearestParking implements IParkingStrategy{

    @Override
    public ParkingSpot findParkingSpot(VehicleSize vehicleSize, List<ParkingFloor> parkingFloors) {

        for (ParkingFloor parkingFloor: parkingFloors) {
            for (ParkingSpot parkingSpot: parkingFloor.getParkingSpots()) {
                if (parkingSpot.canFit(vehicleSize)) {
                    return parkingSpot;
                }
            }
        }
        throw new RuntimeException("No spot found");
    }
}
