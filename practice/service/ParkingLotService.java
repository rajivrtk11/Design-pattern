package practice.service;

import practice.entity.Floor;
import practice.entity.ParkingLot;
import practice.entity.ParkingSlots;
import practice.entity.VehicleType;
import practice.repository.ParkingDataRepository;

import java.util.List;
import java.util.Map;

public class ParkingLotService {
    Map<String, ParkingSlots> parkingSlotsList;
    ParkingLot parkingLot;
    ParkingDataRepository parkingDataRepository;

    public ParkingLotService() throws CloneNotSupportedException {
        super.clone();
    }
    public void  createParkingLot(ParkingLot parkingLot) {
        parkingDataRepository = new ParkingDataRepository();
        this.parkingLot = parkingLot;
        parkingLot.setFloorList(
                parkingDataRepository.initializeData(parkingLot.getNoOfFloor(), parkingLot.getNoOfSlots())
        );
        System.out.println("Created parking lot with "+parkingLot.getNoOfFloor()+
                " floors and "+parkingLot.getNoOfSlots()+" slots per floor"
        );
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public void parkVehicle(VehicleType vehicleType, String registrationNo, String color) {
        ParkingSlots firstAvailableSlot = getFirstAvailableSlot(vehicleType);
    }

    private ParkingSlots getFirstAvailableSlot(VehicleType vehicleType) {
        List<Floor> floorList = parkingLot.getFloorList();
        // iterate through the floor and find the first available slot for given vehicle

        for(Floor floor: floorList) {

        }
        return null;
    }
}
