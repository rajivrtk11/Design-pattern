package ParkingLot.Strategy.SpotAssignmentStrategy;

import ParkingLot.Model.Gate;
import ParkingLot.Model.VehicleType;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpot(Gate gate, VehicleType vehicleType) {
        /**
         * Here we can return mutiple strategy based on the condition
         * if() {}
         * else if (){}
         * else
         */
        return new NearestSpotAssigningStrategy();
    }

}
