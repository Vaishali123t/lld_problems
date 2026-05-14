package main.java.org.lld.elevator.strategy;

import main.java.org.lld.elevator.enums.ElevatorDirection;
import main.java.org.lld.elevator.enums.ElevatorState;
import main.java.org.lld.elevator.models.Elevator;
import main.java.org.lld.elevator.models.requests.InternalRequest;

import java.util.List;

public class FcfsMovementStrategy implements IElevatorMovementStrategy{

    @Override
    public void move(Elevator elevator) {
        List<InternalRequest> internalRequests = elevator.getFloorRequests();

        while(!internalRequests.isEmpty()) {
            InternalRequest internalRequest = internalRequests.stream().findFirst().get();
            ElevatorDirection elevatorDirection = internalRequest.getCurrentFloor()>internalRequest.getDestinationFloor()? ElevatorDirection.DOWN: ElevatorDirection.UP;
            elevator.setElevatorDirection(elevatorDirection);
            elevator.setElevatorState(ElevatorState.MOVING);
            elevator.getElevatorPanel().resetButton(internalRequest.getDestinationFloor());
            System.out.printf("Moving elevator with id: %s, to floor %s \n", elevator.getElevatorId(), internalRequest.getDestinationFloor());

            // remove all requests with same destination floors
            internalRequests.removeIf(r->r.getDestinationFloor()== internalRequest.getDestinationFloor());
        }
        elevator.setElevatorDirection(ElevatorDirection.IDLE);
        elevator.setElevatorState(ElevatorState.HALTED);
    }

}
