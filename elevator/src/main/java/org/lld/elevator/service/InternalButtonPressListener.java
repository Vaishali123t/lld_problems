package main.java.org.lld.elevator.service;

import main.java.org.lld.elevator.models.Elevator;
import main.java.org.lld.elevator.models.requests.InternalRequest;

public interface InternalButtonPressListener {
    void onButtonPressed(InternalRequest internalRequest);
}
