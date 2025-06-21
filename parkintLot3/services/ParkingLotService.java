package parkintLot3.services;

import parkintLot3.entity.*;
import parkintLot3.repository.ParkingDataRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ParkingLotService {
    HashMap<String, Vehicle> vehicleHashMap;
    ParkingLot parkingLot;
    ParkingDataRepository parkingDataRepository;

    public void createParkingLot(ParkingLot parkingLot) {
        vehicleHashMap = new HashMap<>();
        this.parkingLot = parkingLot;
        parkingDataRepository = new ParkingDataRepository();
        this.parkingLot.setParkingFloors(
                parkingDataRepository.initializeData(parkingLot.getNoOfFloors(), parkingLot.getNoOfSlotsPerFloor())
        );
        System.out.println("Created parking lot with "+ parkingLot.getNoOfFloors()+
                "floors and "+ parkingLot.getNoOfSlotsPerFloor()+ " slots per floor");
    }

    public void parkVehicle(VehicleType vehicleType, String vehicleRegisterNo, String color) {
        ParkingSlot parkingSlot = getFirstAvailableSlot(vehicleType);
        if(parkingSlot == null) {
            System.out.println("Parking Lot Full");
        }
        else {
            parkingSlot.setFree(false);
            Vehicle vehicle = new Vehicle(vehicleType, parkingSlot, color, vehicleRegisterNo);
            String ticket = generateTicket(parkingSlot);
            vehicle.setTicketId(ticket);
            vehicleHashMap.put(ticket, vehicle);
            System.out.println("Parked vehicle. Seat ID: "+ ticket);
        }
    }

    public void  unParkVehicle(String ticketId) {
        if(vehicleHashMap.get(ticketId) != null) {
            Vehicle vehicle = vehicleHashMap.get(ticketId);
            ParkingSlot parkingSlot = vehicle.getParkingSlot();
            parkingSlot.setFree(true);
//            parkingLot.getParkingFloors().get(parkingSlot.getFloorId()).getParkingSlots().get(parkingSlot.getSlotId()).setFree(true);
            vehicleHashMap.remove(ticketId);
            System.out.println("Unparked vehicle with Registration Number:" + vehicle.getVehicleRegisterNo()+
                    "and color:"+ vehicle.getColor());
        }
        else {
            System.out.println("Invalid Seat");
        }
    }

    public void display(DisplayType displayType, VehicleType  vehicleType){
        if(displayType == DisplayType.FREE_COUNT) {
            displayFreeCount(vehicleType);
        }
        else if(displayType == DisplayType.FREE_SLOTS) {
            displayFreeSlots(vehicleType);
        }
        else if(displayType == DisplayType.OCCUPIED_SLOTS) {
            displayOccupiedSlots(vehicleType);
        }
        else {
            System.out.println("INVALID DISPLAY");
        }
    }

    private void displayOccupiedSlots(VehicleType vehicleType) {
        for(int i = 0; i < parkingLot.getParkingFloors().size(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(i);
            List<ParkingSlot> collect = parkingFloor.getParkingSlots()
                    .stream()
                    .filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType))
                    .filter(parkingSlot -> !parkingSlot.isFree()).toList();

            StringBuilder printStatement = new StringBuilder("Occupied slots for "+vehicleType+" on Floor "+(i+1)+" :");
            for(ParkingSlot parkingSlot: collect) {
                printStatement.append(parkingSlot.getSlotId()+1);
                printStatement.append(",");
            }
            System.out.println(printStatement);
        }
    }

    private void displayFreeSlots(VehicleType vehicleType) {
        for(int i = 0; i < parkingLot.getParkingFloors().size(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(i);
            List<ParkingSlot> collect = parkingFloor.getParkingSlots()
                    .stream()
                    .filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType))
                    .filter(ParkingSlot::isFree).toList();
            StringBuilder printStatement = new StringBuilder("Free slots for "+vehicleType+ " on Floor "+(i+1)+ " :");
            for(ParkingSlot parkingSlot: collect) {
                printStatement.append(parkingSlot.getSlotId()+1);
                printStatement.append(",");
            }
            System.out.println(collect+"collect is");
            System.out.println(printStatement);
        }
    }

    private void displayFreeCount(VehicleType vehicleType) {
        for(int i = 0; i < parkingLot.getParkingFloors().size(); i++) {
            int count = 0;
            List<ParkingSlot> parkingSlots = parkingLot.getParkingFloors().get(i).getParkingSlots();
            for(int j = 0; j < parkingSlots.size(); j++) {
                if(parkingSlots.get(j).getVehicleType().equals(vehicleType) && parkingSlots.get(j).isFree()) {
                    count++;
                }
            }
            System.out.println("No. of free slots for "+ vehicleType+" on Floor "+(i+1)+" :"+count);
        }
    }

    private String generateTicket(ParkingSlot parkingSlot) {
        return parkingLot.getParkingLotId()+"_"+(parkingSlot.getFloorId()+1)+"_"+(parkingSlot.getSlotId()+1);
    }

    private ParkingSlot getFirstAvailableSlot(VehicleType vehicleType) {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for(ParkingFloor parkingFloor: parkingFloors) {
            List<ParkingSlot> parkingSlots = getAvailableVehicleTypeParkingSlot(parkingFloor.getParkingSlots(), vehicleType);
            for(ParkingSlot parkingSlot: parkingSlots) {
                if(parkingSlot.getVehicleType().equals(vehicleType) && parkingSlot.isFree()) {
                    return parkingSlot;
                }
            }
        }

        return null;
    }

    private List<ParkingSlot> getAvailableVehicleTypeParkingSlot(List<ParkingSlot> parkingSlots, VehicleType vehicleType) {
        if(vehicleType.equals(VehicleType.TRUCK) && parkingSlots.size() >= 1) {
            return Arrays.asList(parkingSlots.get(0));
        }
        else if(vehicleType.equals(VehicleType.BIKE) && parkingSlots.size() >= 3) {
            return Arrays.asList(parkingSlots.get(1), parkingSlots.get(2));
        }
        else return parkingSlots;
    }
}
