package elevatorsystem.models;

import elevatorsystem.enums.Direction;
import elevatorsystem.enums.RequestSource;

public class Request {
    private final int targetFloor;
    private final Direction direction;
    private final RequestSource source;

    public Request(int targetFloor, Direction direction, RequestSource source) {
        this.targetFloor = targetFloor;
        this.direction = direction;
        this.source = source;
    }

    @Override
    public String toString() {
        return source + " Request to floor " + targetFloor +
                (source == RequestSource.EXTERNAL ? " going "+ direction : "");
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public RequestSource getSource() {
        return source;
    }
}
