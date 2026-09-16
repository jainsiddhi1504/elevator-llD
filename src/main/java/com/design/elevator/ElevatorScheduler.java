package com.design.elevator;

import com.design.elevator.enums.ElevatorDirection;

import java.util.List;

public class ElevatorScheduler {
    private final List<ElevatorController> elevatorControllers;
    private ElevatorSelectionStrategy elevatorSelectionStrategy;
    public ElevatorScheduler(List<ElevatorController> elevatorControllers,ElevatorSelectionStrategy elevatorSelectionStrategy){
        this.elevatorControllers=elevatorControllers;
        this.elevatorSelectionStrategy=elevatorSelectionStrategy;
    }
    public  void setStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy){
        this.elevatorSelectionStrategy=elevatorSelectionStrategy;
    }
    public ElevatorController assignElevator(int floor,ElevatorDirection elevatorDirection){
        return elevatorSelectionStrategy.selectElevator(elevatorControllers,floor,elevatorDirection);
    }
}
