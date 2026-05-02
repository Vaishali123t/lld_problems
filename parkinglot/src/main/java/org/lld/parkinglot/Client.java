package main.java.org.lld.parkinglot;

import main.java.org.lld.parkinglot.enums.PaymentType;
import main.java.org.lld.parkinglot.enums.SpotStatus;
import main.java.org.lld.parkinglot.enums.SpotType;
import main.java.org.lld.parkinglot.enums.VehicleSize;
import main.java.org.lld.parkinglot.model.*;
import main.java.org.lld.parkinglot.service.*;
import main.java.org.lld.parkinglot.strategy.fee.HourlyFee;
import main.java.org.lld.parkinglot.strategy.parking.IParkingStrategy;
import main.java.org.lld.parkinglot.strategy.parking.NearestParking;
import main.java.org.lld.parkinglot.strategy.payment.IPaymentStrategy;
import main.java.org.lld.parkinglot.strategy.payment.PaymentStrategyFactory;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        System.out.println("Welcome to parking lot");

        ParkingSpot parkingSpot1 = new ParkingSpot(SpotType.COMPACT, SpotStatus.AVAILABLE);
        ParkingSpot parkingSpot2 = new ParkingSpot(SpotType.COMPACT, SpotStatus.AVAILABLE);
        ParkingSpot parkingSpot3 = new ParkingSpot(SpotType.REGULAR, SpotStatus.AVAILABLE);
        ParkingSpot parkingSpot4 = new ParkingSpot(SpotType.REGULAR, SpotStatus.AVAILABLE);
        ParkingSpot parkingSpot5 = new ParkingSpot(SpotType.LARGE, SpotStatus.AVAILABLE);

        ParkingSpot parkingSpot6 = new ParkingSpot(SpotType.COMPACT, SpotStatus.AVAILABLE);
        ParkingSpot parkingSpot7 = new ParkingSpot(SpotType.REGULAR, SpotStatus.AVAILABLE);
        ParkingSpot parkingSpot8 = new ParkingSpot(SpotType.REGULAR, SpotStatus.AVAILABLE);
        ParkingSpot parkingSpot9 = new ParkingSpot(SpotType.COMPACT, SpotStatus.AVAILABLE);
        ParkingSpot parkingSpot10 = new ParkingSpot(SpotType.LARGE, SpotStatus.AVAILABLE);

        ParkingFloor parkingFloor1 = new ParkingFloor(0, List.of(parkingSpot1, parkingSpot2, parkingSpot3, parkingSpot4, parkingSpot5));
        ParkingFloor parkingFloor2 = new ParkingFloor(1, List.of(parkingSpot6, parkingSpot7, parkingSpot8, parkingSpot9, parkingSpot10));

        ParkingLot parkingLot = ParkingLot.createParkingLot(List.of(parkingFloor1, parkingFloor2));

        // create gates
        IParkingStrategy parkingStrategy = new NearestParking();
        ParkingService parkingService = new ParkingService(parkingLot,parkingStrategy);
        EntryGate entryGate1 = new EntryGate(1, parkingService);
        EntryGate entryGate2 = new EntryGate(2, parkingService);
        ExitGate exitGate1 = new ExitGate(1, parkingService);
        ExitGate exitGate2 = new ExitGate(2, parkingService);

        parkingLot.setEntryGates(List.of(entryGate1, entryGate2));
        parkingLot.setExitGates(List.of(exitGate1, exitGate2));

        Car car = new Car("license1", "Red", VehicleSize.MEDIUM);
        // car entering
        Ticket ticket = parkingLot.getEntryGates().get(0).enter(car);
        // car exiting
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method for your vehicle:");
        System.out.println("1. UPI");
        System.out.println("2. CREDIT_CARD");
        String input = scanner.next().toUpperCase();

        try {
            PaymentType paymentType = PaymentType.valueOf(input);
            System.out.println("You chose: " + paymentType);
            PaymentStrategyFactory paymentStrategyFactory = new PaymentStrategyFactory();
            // create payment strategy
            IPaymentStrategy paymentStrategy = paymentStrategyFactory.getPaymentStrategy(paymentType);
            System.out.printf("payment strategy chosen %s \n", paymentStrategy.getPaymentType());
            parkingLot.getExitGates().get(0).exit(ticket, paymentStrategy, new HourlyFee());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice!");
        }

    }
}