package main.java.org.lld.elevator.models;


import main.java.org.lld.elevator.models.buttons.FloorButton;

public class Floor {
    private int floorNumber;
    private FloorButton upButton;
    private FloorButton downButton;

    public Floor(int floorNumber, FloorButton upButton, FloorButton downButton) {
        this.floorNumber = floorNumber;
        this.upButton = upButton;
        this.downButton = downButton;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public FloorButton getUpButton() {
        return upButton;
    }

    public FloorButton getDownButton() {
        return downButton;
    }

    public Elevator pressUp() {
        return this.upButton.press();
    }

    public Elevator pressDown() {
        return this.downButton.press();
    }

}
