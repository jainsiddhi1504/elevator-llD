package com.design.elevator;

import com.design.elevator.enums.ElevatorDirection;
import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{

    @Override//says the method that the method is implementing a function that is declared in my interface
    public ElevatorController selectElevator(List<ElevatorController> controllers,int requestFloor,ElevatorDirection direction){
        ElevatorController best=null;
        int minDis=Integer.MAX_VALUE;
        //pick the one which is going in that direction and has the minimum distance
        for(ElevatorController controller:controllers){
            int nextStoppage=controller.elevatorCar.nextFloorStoppage;
            //assume good if movi g in that direction and not passed that floor
            boolean isSameDirectionCandidate=controller.elevatorCar.elevatorDirection==direction && ((direction==ElevatorDirection.UP && nextStoppage<=requestFloor)||(direction==ElevatorDirection.DOWN && nextStoppage>=requestFloor));
            int dist=Math.abs(nextStoppage-requestFloor);
            if(isSameDirectionCandidate && (dist<minDis)){
                minDis=dist;
                best=controller;
            }
        }
        //fallback:if not able to choos or choose the idle
        if(best==null){
            for(ElevatorController controller:controllers){
                if(controller.elevatorCar.elevatorDirection==ElevatorDirection.IDLE){
                    best=controller;
                    break;
                }
            }
        }
        //no elvator is free or moving in that direction
        if(best==null){
            best=controllers.get(0);
        }
        return best;
    }
}
