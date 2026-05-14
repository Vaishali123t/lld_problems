package main.java.org.lld.elevator.strategy;

import main.java.org.lld.elevator.models.Elevator;
import main.java.org.lld.elevator.models.requests.ExternalRequest;

import java.util.List;

public class LeastWeightStrategy implements IElevatorAssignmentStrategy{
    @Override
    public Elevator getElevator(ExternalRequest externalRequest, List<Elevator> elevators) {
        // elevator with current least weight is assigned
        return null;
    }
}
