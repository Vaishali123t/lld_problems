package main.java.org.lld.elevator.models;

import main.java.org.lld.elevator.enums.ElevatorDirection;
import main.java.org.lld.elevator.enums.ElevatorState;
import main.java.org.lld.elevator.models.requests.InternalRequest;

import java.util.List;


public class Elevator {

    private int elevatorId;
    private int maxWeight;
    private int maxFloor;
    private int currentFloor;
    private Door door;
    private ElevatorState elevatorState;
    private ElevatorDirection elevatorDirection;
    private List<InternalRequest> internalRequests;
    private ElevatorPanel elevatorPanel;

    public Elevator(int elevatorId, int maxWeight, int maxFloor, int currentFloor, Door door, ElevatorState elevatorState, ElevatorDirection elevatorDirection) {
        this.elevatorId = elevatorId;
        this.maxWeight = maxWeight;
        this.maxFloor = maxFloor;
        this.currentFloor = currentFloor;
        this.door = door;
        this.elevatorState = elevatorState;
        this.elevatorDirection = elevatorDirection;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public ElevatorDirection getElevatorDirection() {
        return elevatorDirection;
    }

    public void setElevatorDirection(ElevatorDirection elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }
    public List<InternalRequest> getFloorRequests() {
        return internalRequests;
    }

    public void setFloorRequests(List<InternalRequest> internalRequests) {

        this.internalRequests = internalRequests;
    }

    public void setElevatorPanel(ElevatorPanel elevatorPanel) {
        this.elevatorPanel = elevatorPanel;
    }

    public void addRequest(InternalRequest internalRequest) {
        this.internalRequests.add(internalRequest);
    }


    public ElevatorPanel getElevatorPanel() {
        return elevatorPanel;
    }

    public List<InternalRequest> getInternalRequests() {
        return internalRequests;
    }
}
