package com.design.elevator;

import com.design.elevator.enums.ElevatorDirection;

import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController implements Runnable {

    PriorityBlockingQueue<Integer> upMinPQ;
    PriorityBlockingQueue<Integer> downMaxPQ;

    ElevatorCar elevatorCar; //elevator controller uses this elevato car to know thing like floor,direction,etc
    private final Object monitor = new Object();

    @Override
    public void run() {

        while (true) {

            if (!upMinPQ.isEmpty()) {
                int destinationFloor = upMinPQ.poll();
                elevatorCar.moveElevator(destinationFloor);
            }
            else if (!downMaxPQ.isEmpty()) {
                int destinationFloor = downMaxPQ.poll();
                elevatorCar.moveElevator(destinationFloor);
            }
            else {
                synchronized (monitor) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
    }

    ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityBlockingQueue<>();
        downMaxPQ=new PriorityBlockingQueue<>(10,(a,b)->b-a);

    }
    public void submitRequest(int destinationFloor){
        enqueueRequest(destinationFloor);
  }
  private void enqueueRequest(int destinationFloor){
        System.out.println("Request details:Destination Floor " + destinationFloor + " accepted by elevator.");
        if(destinationFloor==elevatorCar.nextFloorStoppage){
            return;
        }
        if(destinationFloor>=elevatorCar.nextFloorStoppage){
            if(!upMinPQ.contains(destinationFloor)){
                upMinPQ.offer(destinationFloor);
            }
        }
        else{
            if(!downMaxPQ.contains(destinationFloor)){
                downMaxPQ.offer(destinationFloor);
            }
        }
        synchronized (monitor){//monitor object means that if there is any elevator sleeping it tells wake up wake up there is a request
            monitor.notify();;
        }
    }

}
