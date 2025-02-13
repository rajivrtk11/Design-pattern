package practice.entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String parkingLotId;
    int noOfFloor;
    int noOfSlots;
    List<Floor> floorList;

    public ParkingLot(String parkingLotId, int noOfFloor, int noOfSlots) {
        this.parkingLotId = parkingLotId;
        this.noOfFloor = noOfFloor;
        this.noOfSlots = noOfSlots;
        this.floorList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkingLotId='" + parkingLotId + '\'' +
                ", noOfFloor=" + noOfFloor +
                ", noOfSlots=" + noOfSlots +
                ", floorList=" + floorList +
                '}';
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getNoOfFloor() {
        return noOfFloor;
    }

    public void setNoOfFloor(int noOfFloor) {
        this.noOfFloor = noOfFloor;
    }

    public int getNoOfSlots() {
        return noOfSlots;
    }

    public void setNoOfSlots(int noOfSlots) {
        this.noOfSlots = noOfSlots;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }
}
