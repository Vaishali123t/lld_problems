package main.java.org.lld.parkinglot.model;

import main.java.org.lld.parkinglot.strategy.fee.IFeeStrategy;
import main.java.org.lld.parkinglot.strategy.payment.IPaymentStrategy;
import main.java.org.lld.parkinglot.service.ParkingService;

public class ExitGate extends Gate{

    public ExitGate(int gateNumber, ParkingService parkingService) {
        super(gateNumber,parkingService);
    }

    public void exit(Ticket ticket, IPaymentStrategy paymentStrategy, IFeeStrategy feeStrategy) {
        parkingService.unpark(ticket,paymentStrategy, feeStrategy);
        System.out.printf("Vehicle unparked");
    }

}
