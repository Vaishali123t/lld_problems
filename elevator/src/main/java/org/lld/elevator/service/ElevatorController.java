package main.java.org.lld.elevator.service;

import main.java.org.lld.elevator.models.Elevator;
import main.java.org.lld.elevator.models.requests.ElevatorRequest;
import main.java.org.lld.elevator.models.requests.ExternalRequest;
import main.java.org.lld.elevator.strategy.IElevatorAssignmentStrategy;
import main.java.org.lld.elevator.strategy.IElevatorMovementStrategy;

import java.util.List;

public class ElevatorController {

    private List<Elevator> elevators;
    private IElevatorAssignmentStrategy elevatorAssignmentStrategy;
    private IElevatorMovementStrategy elevatorMovementStrategy;


    public List<Elevator> getElevators() {
        return elevators;
    }

    public void setElevators(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public IElevatorAssignmentStrategy getElevatorAssignmentStrategy() {
        return elevatorAssignmentStrategy;
    }

    public void setElevatorAssignmentStrategy(IElevatorAssignmentStrategy elevatorAssignmentStrategy) {
        this.elevatorAssignmentStrategy = elevatorAssignmentStrategy;
    }

    public IElevatorMovementStrategy getElevatorMovementStrategy() {
        return elevatorMovementStrategy;
    }

    public void setElevatorMovementStrategy(IElevatorMovementStrategy elevatorMovementStrategy) {
        this.elevatorMovementStrategy = elevatorMovementStrategy;
    }

    public Elevator assignElevator(ExternalRequest externalRequest) {
        return elevatorAssignmentStrategy.getElevator(externalRequest,elevators);
    }

    public void moveToNext(Elevator elevator) {
        elevatorMovementStrategy.move(elevator);
    }

    public Elevator handleExternalRequest(ExternalRequest externalRequest) {
        Elevator elevator = assignElevator(externalRequest);
        System.out.printf("Elevator with elevator id: %s assigned. Moving in %s direction: %n", elevator.getElevatorId(), elevator.getElevatorDirection());
        return elevator;
    }

    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }
}
