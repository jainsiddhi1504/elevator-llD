package com.design.elevator;

import com.design.elevator.enums.DoorState;

public class Door {
    private  DoorState doorState;
    Door(){
        doorState=DoorState.DOOR_CLOSE;
    }
    public void openDoor(int id){
        doorState=DoorState.DOOR_OPEN;
        System.out.println("Opening the door of the elevator " + id);
    }
    public void closeDoor(int id){
        doorState=DoorState.DOOR_CLOSE;
        System.out.println("Closing the door of the elevator " + id);
    }
}
