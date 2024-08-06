package ParkingLot.Strategy.SpotAssignmentStrategy;

import ParkingLot.Model.Gate;
import ParkingLot.Model.ParkingSpot;
import ParkingLot.Model.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot getSpot(Gate gate, VehicleType vehicleType);
}
