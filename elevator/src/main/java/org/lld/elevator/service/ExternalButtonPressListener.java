package main.java.org.lld.elevator.service;

import main.java.org.lld.elevator.models.Elevator;
import main.java.org.lld.elevator.models.requests.ExternalRequest;

// Button just fires an event, knows nothing about who handles it -- functional interface
public interface ExternalButtonPressListener {
    Elevator onButtonPressed(ExternalRequest externalRequest);
}
