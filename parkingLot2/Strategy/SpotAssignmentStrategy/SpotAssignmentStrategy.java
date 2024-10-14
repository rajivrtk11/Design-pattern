package parkingLot2.Strategy.SpotAssignmentStrategy;

import parkingLot2.Model.Gate;
import parkingLot2.Model.ParkingSpot;
import parkingLot2.Model.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot getSpot(Gate gate, VehicleType vehicleType);
}
