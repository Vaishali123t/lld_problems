package main.java.org.lld.elevator.models;

import main.java.org.lld.elevator.enums.Direction;
import main.java.org.lld.elevator.enums.ElevatorDirection;
import main.java.org.lld.elevator.enums.ElevatorState;
import main.java.org.lld.elevator.models.buttons.CabinButton;
import main.java.org.lld.elevator.models.buttons.FloorButton;
import main.java.org.lld.elevator.models.requests.InternalRequest;
import main.java.org.lld.elevator.service.ElevatorController;
import main.java.org.lld.elevator.service.InternalButtonPressListener;
import main.java.org.lld.elevator.strategy.DirectionalStrategy;
import main.java.org.lld.elevator.strategy.FcfsMovementStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Building {

    private String name;
    private List<Floor> floors;
    private ElevatorController elevatorController;

    public Building(int numFloors, int numElevators) {
        this.name = "building";
        this.floors = initFloors(numFloors);
        this.elevatorController  = initElevatorController(numElevators);

        wireButtons();   // Building is the only place that knows about both
    }

    public Building(String name, List<Floor> floors, ElevatorController elevatorController) {
        this.name = name;
        this.floors = floors;
        this.elevatorController = elevatorController;
    }

    public ElevatorController getElevatorController() {
        return elevatorController;
    }

    private List<Floor> initFloors(int n) {
        List<Floor> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new Floor(i, new FloorButton(i, Direction.UP),new FloorButton(i, Direction.DOWN)));
        return list;
    }

    private List<Elevator> initElevators(int n) {
        List<Elevator> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Elevator elevator = new Elevator(i,100,8,0,new Door(), ElevatorState.HALTED, ElevatorDirection.IDLE);
            elevator.setFloorRequests(new ArrayList<>());
            list.add(elevator);
        }
        // add internal buttons for elevator
        wireElevatorPanel(list);
        return list;
    }

    private void wireElevatorPanel(List<Elevator> elevators) {
        for (Elevator elevator: elevators) {
            ElevatorPanel panel = new ElevatorPanel(elevator.getElevatorId(),8);
            elevator.setElevatorPanel(panel);
            Collection<CabinButton> buttons = panel.getAllButtons();
            for (CabinButton button: buttons) {
                button.setListener(new InternalButtonPressListener() {
                    @Override
                    public void onButtonPressed(InternalRequest internalRequest) {
                        elevator.addRequest(internalRequest);
                        elevatorController.moveToNext(elevator);
                    }
                });
            }
        }
    }

    private ElevatorController initElevatorController(int numElevators) {
        List<Elevator> elevators = initElevators(numElevators);
        ElevatorController controller = new ElevatorController();
        controller.setElevators(elevators);
        controller.setElevatorAssignmentStrategy(new DirectionalStrategy());
        controller.setElevatorMovementStrategy(new FcfsMovementStrategy());
        return controller;
    }

    private void wireButtons() {

            //
            for (Floor floor : floors) {
                // Building registers itself as the listener
                floor.getUpButton().setListener(
                        elevatorRequest -> elevatorController.handleExternalRequest(
                                elevatorRequest));
                floor.getDownButton().setListener(
                        elevatorRequest -> elevatorController.handleExternalRequest(
                                elevatorRequest));
            }
        }

        public Floor getFloor(int num) {
            return floors.get(num);
        }
}
