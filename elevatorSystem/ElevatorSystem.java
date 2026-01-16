package elevatorSystem;

import elevatorSystem.entities.Elevator;
import elevatorSystem.entities.ElevatorState;
import elevatorSystem.entities.Floor;
import elevatorSystem.entities.MOVING_DIRECTION;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Data
@AllArgsConstructor
public class ElevatorSystem {
    private List<Floor> floors;
    List<Elevator> elevatorList;
    List<Integer> requirementList;

    public void assignElevator(int src, int dest, MOVING_DIRECTION movingDirection) {
        // TODO: ASSIGN ELEVATOR
        Elevator assignedElevator = null;
        int minDist = (int)1e9;

        for (Elevator elevator : elevatorList){
            if(elevator.getMovingDirection().equals(movingDirection) ||
                    elevator.getElevatorState().equals(ElevatorState.IDLE)
            ) {
                int min = Math.abs(elevator.getCurrentFloor() - src);
                if(min < minDist) {
                    assignedElevator = elevator;
                }
            }
        }


        if(assignedElevator == null) {
            assignedElevator = elevatorList.get(0);
        }
    }

    public void startElevator() {
        // TODO: START ELEVATOR
    }
}
