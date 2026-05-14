package main.java.org.lld.elevator.models.buttons;

import main.java.org.lld.elevator.models.requests.InternalRequest;
import main.java.org.lld.elevator.service.InternalButtonPressListener;

public class CabinButton implements IButton {

    private int elevatorId;
    private int destinationFloor;
    private boolean isLit;
    private InternalButtonPressListener listener;

    public CabinButton(int elevatorId,int destinationFloor) {
        this.elevatorId = elevatorId;
        this.destinationFloor = destinationFloor;
    }

    public CabinButton getCabinButton() {
        return this;
    }

    public void reset() { isLit = false; }  // called when elevator arrives at floor

    public void setListener(InternalButtonPressListener listener) {
        this.listener = listener;
    }

    public void press(int elevatorId) {
        if (isLit) return;
        isLit = true;
        listener.onButtonPressed(new InternalRequest(elevatorId,this.destinationFloor));
    }
}
