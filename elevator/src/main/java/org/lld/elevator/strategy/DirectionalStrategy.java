package main.java.org.lld.elevator.strategy;

import main.java.org.lld.elevator.enums.Direction;
import main.java.org.lld.elevator.enums.ElevatorDirection;
import main.java.org.lld.elevator.enums.ElevatorState;
import main.java.org.lld.elevator.models.Elevator;
import main.java.org.lld.elevator.models.requests.ExternalRequest;

import java.util.List;

public class DirectionalStrategy implements IElevatorAssignmentStrategy{


    @Override
    public Elevator getElevator(ExternalRequest externalRequest, List<Elevator> elevators) {
        // try to assign the closest elevator moving is same direction
        Direction requestedDirection = externalRequest.getDirection();
        int requestedFloor = externalRequest.getCurrentFloor();

        Elevator assignedElevator = elevators.stream().filter(elevator -> elevator.getElevatorDirection().name().equals(requestedDirection.name()) || elevator.getElevatorDirection().equals(ElevatorDirection.IDLE))
                .min((ele1,ele2)->{
                    int dis1 = Math.abs(ele1.getCurrentFloor()-requestedFloor);
                    int dis2 = Math.abs(ele2.getCurrentFloor()-requestedFloor);
                    return dis1-dis2;
                }).orElse(null);

        if (assignedElevator.getElevatorDirection().equals(ElevatorDirection.IDLE)) {
            assignedElevator.setElevatorDirection(ElevatorDirection.valueOf(requestedDirection.name()));
            assignedElevator.setElevatorState(ElevatorState.MOVING);
        }
        return assignedElevator;
    }
}
