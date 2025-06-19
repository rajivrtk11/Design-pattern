// Complete working Elevator System in Java (simplified for console simulation)

import java.util.*;

enum Direction {
    UP, DOWN, IDLE
}

enum ElevatorState {
    MOVING, STOPPED, IDLE, DOOR_OPEN
}

class Request {
    int floor;
    Direction direction;

    public Request(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }
}

interface Scheduler {
    void schedule(List<Elevator> elevators, int floor, Direction direction);
}

class DefaultScheduler implements Scheduler {
    public void schedule(List<Elevator> elevators, int floor, Direction direction) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (elevator.getState() != ElevatorState.MOVING || elevator.getDirection() == direction) {
                int distance = Math.abs(elevator.getCurrentFloor() - floor);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }

        if (bestElevator != null) {
            bestElevator.addDestination(floor);
        }
    }
}

class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private TreeSet<Integer> destinationFloors;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;
        this.destinationFloors = new TreeSet<>();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getState() {
        return state;
    }

    public void addDestination(int floor) {
        destinationFloors.add(floor);
        updateDirection();
    }

    private void updateDirection() {
        if (destinationFloors.isEmpty()) {
            direction = Direction.IDLE;
            state = ElevatorState.IDLE;
            return;
        }
        direction = (destinationFloors.first() > currentFloor) ? Direction.UP : Direction.DOWN;
        state = ElevatorState.MOVING;
    }

    public void move() {
        if (destinationFloors.isEmpty()) {
            direction = Direction.IDLE;
            state = ElevatorState.IDLE;
            return;
        }

        if (direction == Direction.UP) {
            currentFloor++;
        } else if (direction == Direction.DOWN) {
            currentFloor--;
        }

        System.out.println("Elevator " + id + " at floor: " + currentFloor);

        if (destinationFloors.contains(currentFloor)) {
            openDoor();
            destinationFloors.remove(currentFloor);
            closeDoor();
            updateDirection();
        }
    }

    private void openDoor() {
        state = ElevatorState.DOOR_OPEN;
        System.out.println("Elevator " + id + " opening door at floor: " + currentFloor);
    }

    private void closeDoor() {
        System.out.println("Elevator " + id + " closing door at floor: " + currentFloor);
        state = ElevatorState.MOVING;
    }
}

class ElevatorSystem {
    private List<Elevator> elevators;
    private Scheduler scheduler;

    public ElevatorSystem(int numberOfElevators) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numberOfElevators; i++) {
            elevators.add(new Elevator(i));
        }
        scheduler = new DefaultScheduler();
    }

    public void requestElevator(int floor, Direction direction) {
        scheduler.schedule(elevators, floor, direction);
    }

    public void step() {
        for (Elevator elevator : elevators) {
            elevator.move();
        }
    }

    public void simulate(int steps) {
        for (int i = 0; i < steps; i++) {
            System.out.println("--- Step " + (i + 1) + " ---");
            step();
        }
    }
}

public class ElevatorMain {
    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem(2);

        system.requestElevator(3, Direction.UP);
        system.requestElevator(5, Direction.DOWN);
        system.requestElevator(3, Direction.UP);

        system.simulate(10);
    }
}
