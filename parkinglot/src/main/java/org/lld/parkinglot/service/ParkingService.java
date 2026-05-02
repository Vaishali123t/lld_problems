package main.java.org.lld.parkinglot.service;

import main.java.org.lld.parkinglot.enums.SpotStatus;
import main.java.org.lld.parkinglot.enums.TicketStatus;
import main.java.org.lld.parkinglot.model.*;
import main.java.org.lld.parkinglot.strategy.fee.IFeeStrategy;
import main.java.org.lld.parkinglot.strategy.parking.IParkingStrategy;
import main.java.org.lld.parkinglot.strategy.payment.IPaymentStrategy;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingService {

    private ParkingLot parkingLot;
    private IParkingStrategy parkingStrategy;

    public ParkingService(ParkingLot parkingLot, IParkingStrategy parkingStrategy) {
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        // find available parking spot
        ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(vehicle.getVehicleSize(), parkingLot.getParkingFloors());
        // park vehicle and update spots
        parkingSpot.setVehicle(vehicle);
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
        System.out.printf("Parking spot assigned to vehicle with license number: %s \n", vehicle.getLicenseNumber());

        // create the ticket
        Ticket ticket = new Ticket(UUID.randomUUID().toString(),parkingSpot,vehicle, LocalDateTime.of(2026, 5, 2, 5, 0), TicketStatus.ACTIVE);
        return ticket;
    }

    public void unpark(Ticket ticket, IPaymentStrategy paymentStrategy, IFeeStrategy feeStrategy) {
        Vehicle vehicle = ticket.getVehicle();
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        ticket.setExitTime(LocalDateTime.now());

        // calculateFee
        double fee = feeStrategy.calculateFee(ticket);
        System.out.printf("Fee calculated: %s \n", fee);
        ticket.setFee(fee);

        // payment
        paymentStrategy.pay(fee);

        // set ticket status to PAID
        ticket.setTicketStatus(TicketStatus.PAID);
        // unpark vehicle
        parkingSpot.setSpotStatus(SpotStatus.AVAILABLE);
        parkingSpot.setVehicle(null);
    }

}
