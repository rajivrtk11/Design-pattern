package elevatorsystem.state;

import elevatorsystem.Elevator;
import elevatorsystem.enums.Direction;
import elevatorsystem.models.Request;

public interface ElevatorState {
    void move(Elevator elevator);
//    void addRequest(Elevator elevator, Request request);
    Direction getDirection();

    default void addRequest(Elevator elevator, Request request) {
        if(request.getTargetFloor() >= elevator.getCurrentFloor()) {
            elevator.getUpRequests().add(request.getTargetFloor());
        }
        else if(request.getTargetFloor() < elevator.getCurrentFloor()) {
            elevator.getDownRequests().add(request.getTargetFloor());
        }
    }
}
