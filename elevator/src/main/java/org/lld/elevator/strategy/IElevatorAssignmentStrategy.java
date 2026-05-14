package main.java.org.lld.elevator.strategy;

import main.java.org.lld.elevator.models.Elevator;
import main.java.org.lld.elevator.models.requests.ElevatorRequest;
import main.java.org.lld.elevator.models.requests.ExternalRequest;

import java.util.List;

public interface IElevatorAssignmentStrategy {

    Elevator getElevator(ExternalRequest externalRequest, List<Elevator> elevators);

}
