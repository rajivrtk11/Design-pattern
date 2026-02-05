package parkinglotlld.strategies.parking;

import parkinglotlld.entities.ParkingFloor;
import parkinglotlld.entities.ParkingSpot;
import parkinglotlld.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public class BestFitStrategy implements ParkingStrategy{
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        Optional<ParkingSpot> bestSpot = Optional.empty();

        for(ParkingFloor floor: floors) {
            Optional<ParkingSpot> spotOnThisFloor = floor.findAvailableSpot(vehicle);

            if(spotOnThisFloor.isPresent()) {
                if(bestSpot.isEmpty()) {
                    // If this is the first spot we've found, it's the best one so far.
                    bestSpot = spotOnThisFloor;
                }
                else {
                    // A smaller spot size enum ordinal mean a tighter fit
                    if(spotOnThisFloor.get().getSpotSize().ordinal() < bestSpot.get().getSpotSize().ordinal()) {
                        bestSpot = spotOnThisFloor;
                    }
                }
            }
        }

        return bestSpot;
    }
}
