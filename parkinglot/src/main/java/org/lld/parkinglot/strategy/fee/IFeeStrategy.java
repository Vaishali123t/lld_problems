package main.java.org.lld.parkinglot.strategy.fee;

import main.java.org.lld.parkinglot.model.Ticket;

public interface IFeeStrategy {

    double calculateFee(Ticket ticket);

}
