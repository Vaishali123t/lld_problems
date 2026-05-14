package main.java.org.lld.elevator.models;

import main.java.org.lld.elevator.models.buttons.CabinButton;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ElevatorPanel {

    private final int elevatorId;
    private final Map<Integer, CabinButton> buttons = new HashMap<>();

    public ElevatorPanel(int elevatorId, int totalFloors) {
        this.elevatorId = elevatorId;
        for (int i = 0; i < totalFloors; i++)
            buttons.put(i, new CabinButton(elevatorId, i));
    }

    public void pressButton(int floor) {
        CabinButton btn = buttons.get(floor);
        if (btn != null) btn.press(elevatorId);
    }

    public void resetButton(int floor) {
        CabinButton btn = buttons.get(floor);
        if (btn != null) btn.reset();
    }

    public Collection<CabinButton> getAllButtons() {
        return buttons.values();
    }
}

