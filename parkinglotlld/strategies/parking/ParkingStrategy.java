package parkinglotlld.strategies.parking;

import parkinglotlld.entities.ParkingFloor;
import parkinglotlld.entities.ParkingSpot;
import parkinglotlld.entities.Vehicle;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
