package com.design.elevator;

import com.design.elevator.enums.ElevatorDirection;


public class ElevatorCar {
    int id;
    int currentFloor;
    int nextFloorStoppage;
    ElevatorDirection elevatorDirection;
    Door door;
    public ElevatorCar(int id){
        this.id=id;
        currentFloor=0;
        elevatorDirection=ElevatorDirection.IDLE;
        door=new Door();
    }
    public void showDisplay(){
        System.out.println("Elevator :"+id+",Current Floor :"+currentFloor+",going: "+elevatorDirection);
    }
    public void moveElevator(int destinationFloor){
        this.nextFloorStoppage=destinationFloor;
        if(currentFloor==destinationFloor){
            door.openDoor(id);
            return;
        }
        int startFloor=this.currentFloor;
        door.closeDoor(id);
        if(nextFloorStoppage>=startFloor){
            elevatorDirection=ElevatorDirection.UP;
            showDisplay();
            for(int i=startFloor+1;i<=nextFloorStoppage;i++){
                try{
                    Thread.sleep(5);
                }catch(Exception e){

                }
                setCurrentFloor(i);
                showDisplay();
            }
        }
        else{
            elevatorDirection=ElevatorDirection.DOWN;
            showDisplay();
            for(int i=startFloor-1;i>=nextFloorStoppage;i--){
                try{
                    Thread.sleep(5);
                }
                catch(Exception e){

                }
                setCurrentFloor(i);
                showDisplay();
            }
        }
    }
    public void setCurrentFloor(int currentFloor){
        this.currentFloor=currentFloor;
    }
}
