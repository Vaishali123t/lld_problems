package main.java.org.lld.parkinglot.model;

import main.java.org.lld.parkinglot.service.ParkingService;

public abstract class Gate {
    protected int gateNumber;
    protected ParkingService parkingService;

    public Gate(int gateNumber, ParkingService parkingService) {
        this.gateNumber = gateNumber;
        this.parkingService = parkingService;
    }

    public int getGateNumber() {
        return gateNumber;
    }

}
