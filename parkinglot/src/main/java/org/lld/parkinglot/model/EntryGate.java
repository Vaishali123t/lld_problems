package main.java.org.lld.parkinglot.model;


import main.java.org.lld.parkinglot.service.ParkingService;

public class EntryGate extends Gate{

    public EntryGate(int number, ParkingService parkingService) {
        super(number,parkingService);
    }

    public Ticket enter(Vehicle vehicle) {
        System.out.printf("Vehicle with license number: %s of size: %s is entering \n", vehicle.getLicenseNumber(), vehicle.getVehicleSize());
        return parkingService.parkVehicle(vehicle);
    }

}
