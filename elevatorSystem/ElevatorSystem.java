package elevatorSystem;

import elevatorSystem.entities.Elevator;
import elevatorSystem.entities.Floor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ElevatorSystem {
    private List<Floor> floors;
    List<Elevator> elevatorList;
    List<Integer> requirementList;

    public void assignElevator() {
        // TODO: ASSIGN ELEVATOR

    }

    public void startElevator() {
        // TODO: START ELEVATOR
    }
}
