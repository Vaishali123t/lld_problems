package main.java.org.lld.elevator.models.requests;


public class InternalRequest{

    private int elevator;
    private int destinationFloor;

    public InternalRequest(int elevator, int destinationFloor) {
        this.elevator = elevator;
        this.destinationFloor = destinationFloor;
    }

    public int getCurrentFloor() {
        return elevator;
    }

    public void setCurrentFloor(int elevator) {
        this.elevator = elevator;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
}
