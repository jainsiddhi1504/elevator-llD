package com.design.elevator;

import com.design.elevator.enums.ElevatorDirection;

public class ExternalButton
{
    private final ExternalDispatcher externalDispatcher;
    public  ExternalButton(ExternalDispatcher externalDispatcher){
        this.externalDispatcher=externalDispatcher;
    }
    public void pressButton(int floor,ElevatorDirection elevatorDirection){
        externalDispatcher.submitExternalRequest(floor, elevatorDirection);
    }
}
