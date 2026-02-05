package elevatorsystem.state;

import elevatorsystem.Elevator;
import elevatorsystem.enums.Direction;
import elevatorsystem.enums.RequestSource;
import elevatorsystem.models.Request;

public class MovingDownState implements ElevatorState{
    @Override
    public void move(Elevator elevator) {
        if(elevator.getDownRequests().isEmpty()) {
            elevator.setState(new IdleState());
            return;
        }

        Integer destinationFloor = elevator.getDownRequests().first();

        if(elevator.getCurrentFloor() == destinationFloor) {
            System.out.println("Elevator "+ elevator.getId() + " stopped at floor " + destinationFloor);
            elevator.getDownRequests().pollFirst();
        }
        elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);

        if(elevator.getDownRequests().isEmpty()){
            elevator.setState(new IdleState());
        }
    }

//    @Override
//    public void addRequest(Elevator elevator, Request request) {
//        // Internal request always get added to the appropriate queue
////        if(request.getSource() == RequestSource.INTERNAL) {
//            if(request.getTargetFloor() > elevator.getCurrentFloor()) {
//                elevator.getUpRequests().add(request.getTargetFloor());
//            }
//            else {
//                elevator.getDownRequests().add(request.getTargetFloor());
//            }
//            return;
////        }
////
////        // External reqeust
////        if(request.getDirection() == Direction.DOWN && request.getTargetFloor() <= elevator.getCurrentFloor()) {
////            elevator.getDownRequests().add(request.getTargetFloor());
////        }
////        else if(request.getDirection() == Direction.UP) {
////            elevator.getUpRequests().add(request.getTargetFloor());
////        }
//    }

    @Override
    public Direction getDirection() {
        return Direction.DOWN;
    }
}
