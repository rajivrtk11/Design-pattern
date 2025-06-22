import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Direction.java
enum Direction {
    UP,
    DOWN,
    IDLE
}

// Command.java
interface Command {
    void execute(Elevator elevator);
    boolean isComplete(Elevator elevator);
}

// PickupCommand.java
class PickupCommand implements Command {
    private final int floor;
    private boolean pickedUp = false;

    PickupCommand(int floor) {
        this.floor = floor;
    }

    @Override
    public void execute(Elevator elevator) {
        if (elevator.getCurrentFloor() < floor) elevator.moveUp();
        else if (elevator.getCurrentFloor() > floor) elevator.moveDown();
        else {
            pickedUp = true;
            System.out.println("Elevator " + elevator.getId() + " picked up at floor " + floor);
        }
    }

    @Override
    public boolean isComplete(Elevator elevator) {
        return pickedUp;
    }
}

// DropCommand.java
class DropCommand implements Command {
    final int floor;
    private boolean droppedOff = false;

    DropCommand(int floor) {
        this.floor = floor;
    }

    @Override
    public void execute(Elevator elevator) {
        if (elevator.getCurrentFloor() < floor) elevator.moveUp();
        else if (elevator.getCurrentFloor() > floor) elevator.moveDown();
        else {
            this.droppedOff = true;
            System.out.println("Elevator " + elevator.getId() + " dropped off at floor " + floor);
        }
    }

    @Override
    public boolean isComplete(Elevator elevator) {
        return this.droppedOff;
    }
}

class Elevator {
    private final int id;
    private int currentFloor = 0;
    private Direction direction = Direction.IDLE;
    private final Queue<Command> commands = new LinkedList<>();

    Elevator(int id) {
        this.id = id;
    }

    void addCommand(Command command) {
        commands.offer(command);
    }

    void step() {
        if (commands.isEmpty()) {
            direction = Direction.IDLE;
            return;
        }

        Command current = commands.peek();
        current.execute(this);

        if (current.isComplete(this)) {
            commands.poll();
        }

        if (commands.isEmpty()) direction = Direction.IDLE;
    }

    void moveUp() { currentFloor++; direction = Direction.UP; }
    void moveDown() { currentFloor--; direction = Direction.DOWN; }

    int getCurrentFloor() { return currentFloor; }
    int getId() { return id; }
    Direction getDirection() { return direction; }
    boolean isIdle() { return commands.isEmpty(); }

    @Override
    public String toString() {
        return "Elevator " + id + " at floor " + currentFloor + " (" + direction + ")";
    }
}

// ElevatorAssignmentStrategy.java
interface ElevatorAssignmentStrategy {
    Elevator selectElevator(List<Elevator> elevators, int sourceFloor);
}

// NearestIdleStrategy.java
class NearestIdleStrategy implements ElevatorAssignmentStrategy {
    @Override
    public Elevator selectElevator(List<Elevator> elevators, int sourceFloor) {
        return elevators.stream()
                .filter(Elevator::isIdle)
                .min((a, b) -> Integer.compare(
                        Math.abs(a.getCurrentFloor() - sourceFloor),
                        Math.abs(b.getCurrentFloor() - sourceFloor)))
                .orElse(elevators.get(0));
    }
}

// ElevatorSystem.java
class ElevatorSystem {
    private static ElevatorSystem instance;
    private final List<Elevator> elevators;
    private final ElevatorAssignmentStrategy strategy;

    private ElevatorSystem(int numElevators, ElevatorAssignmentStrategy strategy) {
        this.strategy = strategy;
        this.elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public static ElevatorSystem getInstance(int count, ElevatorAssignmentStrategy strategy) {
        if (instance == null) {
            instance = new ElevatorSystem(count, strategy);
        }
        return instance;
    }

    void requestElevator(int source, int dest) {
        Elevator selected = strategy.selectElevator(elevators, source);
        selected.addCommand(new PickupCommand(source));
        selected.addCommand(new DropCommand(dest));
        System.out.println("Request (" + source + " → " + dest + ") assigned to Elevator " + selected.getId());
    }

    void step() {
        elevators.forEach(Elevator::step);
    }

    void status() {
        elevators.forEach(System.out::println);
    }
}

// ElevatorMain.java
public class ElevatorMain {
    public static void main(String[] args) throws InterruptedException {
        ElevatorSystem system = ElevatorSystem.getInstance(2, new NearestIdleStrategy());

        system.requestElevator(2, 5);
        system.requestElevator(3, 1);
        system.requestElevator(6, 2);

        for (int i = 0; i < 15; i++) {
            System.out.println("=== STEP " + (i + 1) + " ===");
            system.step();
            system.status();
            Thread.sleep(1000);
        }
    }
}
