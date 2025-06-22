package elevatorSystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Elevator {
    private long id;
    private ElevatorState elevatorState;
    private int currentFloor;
    List<Integer> destinationsInMovingDirection;
    List<Integer> destinationsInOppositeDirection;
}
