package main.java.org.lld.parkinglot.strategy.fee;

import main.java.org.lld.parkinglot.enums.SpotType;
import main.java.org.lld.parkinglot.model.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HourlyFee implements IFeeStrategy{

    @Override
    public double calculateFee(Ticket ticket) {

        SpotType spotType = ticket.getParkingSpot().getSpotType();
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = ticket.getExitTime();
        long hours = ChronoUnit.HOURS.between(entryTime, exitTime);

        return switch (spotType){
            case COMPACT -> 20*hours;
            case REGULAR -> 50*hours;
            case LARGE -> 80*hours;
        };

    }
}
