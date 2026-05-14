package main.java.org.lld.elevator.models;

import main.java.org.lld.elevator.enums.DoorState;

public class Door {

    private DoorState doorState;

    public DoorState getDoorState() {
        return doorState;
    }

    public void setDoorState(DoorState doorState) {
        this.doorState = doorState;
    }
}
