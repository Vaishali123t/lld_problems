package main.java.org.lld.elevator;

import main.java.org.lld.elevator.models.*;
import main.java.org.lld.elevator.models.requests.InternalRequest;


public class Client {

    public static void main(String[] args) {
        System.out.println("Welcome to Elevator System!");

        // building
        Building building = new Building(8,3);

        Elevator elevator1 = building.getFloor(3).getUpButton().press();
        Elevator elevator2 = building.getFloor(2).getDownButton().press();
        Elevator elevator3 = building.getFloor(5).getDownButton().press();


        elevator1.getElevatorPanel().pressButton(5);
        elevator2.getElevatorPanel().pressButton(7);
        Elevator elevator4 = building.getFloor(5).getUpButton().press();
        elevator2.getElevatorPanel().pressButton(6);
        elevator4.getElevatorPanel().pressButton(7);
        elevator3.getElevatorPanel().pressButton(6);
        elevator3.getElevatorPanel().pressButton(6);

    }
}
