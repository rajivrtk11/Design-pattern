package practice.repository;

import practice.entity.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingDataRepository {
    List<ParkingSlots> parkingSlotsList;
    List<Floor> parkingFloor;

    public List<Floor> initializeData(int floorCount, int slotCount) {
        parkingFloor = new ArrayList<>(slotCount);

        for(int i = 0; i < floorCount; i++){
            generateSlots(floorCount, slotCount);
            parkingFloor.add(new Floor(i, slotCount ,parkingSlotsList));
        }
        return parkingFloor;
    }

    private void generateSlots(int floorCount, int slotCount) {
        parkingSlotsList = new ArrayList<>();
        for(int i = 0; i < slotCount; i++) {
            if(i < 1) {
                parkingSlotsList.add(new ParkingSlots(new Vehicle(VehicleType.TRUCK, null, null, null), true, i));
            }
            else if(i < 3) {
                parkingSlotsList.add(new ParkingSlots(new Vehicle(VehicleType.BIKE, null, null, null), true, i));
            }
            else {
                parkingSlotsList.add(new ParkingSlots(new Vehicle(VehicleType.CAR, null, null, null), true, i));
            }
        }
    }
}
