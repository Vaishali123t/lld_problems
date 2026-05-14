package main.java.org.lld.elevator.models.buttons;

import main.java.org.lld.elevator.enums.Direction;
import main.java.org.lld.elevator.models.Elevator;
import main.java.org.lld.elevator.models.requests.ExternalRequest;
import main.java.org.lld.elevator.service.ExternalButtonPressListener;

public class FloorButton implements IButton{
    private final int currentFloor;
    private final Direction direction;
    private boolean isLit;
    private ExternalButtonPressListener listener;   // abstract — no idea who this is

    public FloorButton(int floorNumber, Direction direction) {
        this.currentFloor = floorNumber;
        this.direction   = direction;
    }

    public Elevator press() {
        if (isLit) return null;   // already requested, ignore duplicate press
        isLit = true;
        return listener.onButtonPressed(
                new ExternalRequest(currentFloor, direction));
    }

    public void reset() { isLit = false; }  // called when elevator arrives

    public void setListener(ExternalButtonPressListener listener) {
        this.listener = listener;
    }
}