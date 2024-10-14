package ParkingLot.Model;

import java.util.List;

public class ParkingSpot extends BaseModel{
    private List<Vehicle> supportedVehileTypes;
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor parkingFloor;
    private int spotNumber;

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "supportedVehileTypes=" + (supportedVehileTypes != null ? supportedVehileTypes.toString() : "null") +
                ", parkingSpotStatus=" + (parkingSpotStatus != null ? parkingSpotStatus.toString() : "null") +
                ", parkingFloor=" + (parkingFloor != null ? parkingFloor.toString() : "null") +
                ", spotNumber=" + spotNumber +
                '}';
    }

    public List<Vehicle> getSupportedVehileTypes() {
        return supportedVehileTypes;
    }

    public void setSupportedVehileTypes(List<Vehicle> supportedVehileTypes) {
        this.supportedVehileTypes = supportedVehileTypes;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }
}
