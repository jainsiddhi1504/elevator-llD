# Elevator System - Low Level Design

A Java-based Elevator System designed using Low Level Design (LLD) principles and design patterns.

## Overview

This project simulates a multi-elevator system that handles both external and internal elevator requests.

The system uses different elevator selection strategies to decide which elevator should handle an external request.

## Features

- Multiple elevator support
- Internal elevator requests
- External UP/DOWN requests
- Elevator movement simulation
- Priority-based request handling
- Nearest elevator selection
- Least Busy elevator selection
- Multithreaded elevator controllers
- Thread-safe request queues
- Dynamic elevator selection strategy

## Design Patterns Used

### Strategy Pattern

The `ElevatorSelectionStrategy` interface allows different algorithms to be used for selecting an elevator.

Implemented strategies:

- `NearestElevatorStrategy`
- `LeastBusyStrategy`

The strategy can be changed dynamically through `ElevatorScheduler`.

### Singleton Pattern

`InternalDispatcher` uses the Singleton pattern to ensure that a single dispatcher instance handles internal elevator requests.

## Technologies Used

- Java 21
- Maven
- Multithreading
- `PriorityBlockingQueue`
- Java Collections

## Project Structure

```text
com.design.elevator
│
├── Building.java
├── Door.java
├── ElevatorCar.java
├── ElevatorController.java
├── ElevatorScheduler.java
├── ElevatorSelectionStrategy.java
├── ExternalButton.java
├── ExternalDispatcher.java
├── Floor.java
├── InternalButton.java
├── InternalDispatcher.java
├── LeastBusyStrategy.java
├── NearestElevatorStrategy.java
│
└── enums
    ├── DoorState.java
    └── ElevatorDirection.java