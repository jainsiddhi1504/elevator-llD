package com.design.elevator;

public class InternalButton {
    private final ElevatorController elevatorController;
    public InternalButton(ElevatorController elevatorController){
        this.elevatorController=elevatorController;
    }
    public void pressButton(int destinationFloor){
        InternalDispatcher.getInstance()
                .submitInternalRequest(destinationFloor, elevatorController);//
    }
}
