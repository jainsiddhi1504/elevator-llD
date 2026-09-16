package com.design.elevator;

import com.design.elevator.enums.ElevatorDirection;
import java.util.List;

public class ExternalDispatcher {
    ElevatorScheduler elevatorScheduler;
    public ExternalDispatcher(ElevatorScheduler elevatorScheduler){
        this.elevatorScheduler=elevatorScheduler;
    }
    public void submitExternalRequest(int floor,ElevatorDirection elevatorDirection){
        ElevatorController controller=elevatorScheduler.assignElevator(floor,elevatorDirection);
        controller.submitRequest(floor);
    }
}
