package practice.entity;

import java.util.List;

public class Floor {
    int floorId;
    int noOfSlots;
    List<ParkingSlots> parkingSlotsList;

    public Floor(int floorId, int noOfSlots, List<ParkingSlots> parkingSlotsList) {
        this.floorId = floorId;
        this.noOfSlots = noOfSlots;
        this.parkingSlotsList = parkingSlotsList;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorId=" + floorId +
                ", noOfSlots=" + noOfSlots +
                ", parkingSlotsList=" + parkingSlotsList +
                '}';
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getNoOfSlots() {
        return noOfSlots;
    }

    public void setNoOfSlots(int noOfSlots) {
        this.noOfSlots = noOfSlots;
    }

    public List<ParkingSlots> getParkingSlotsList() {
        return parkingSlotsList;
    }

    public void setParkingSlotsList(List<ParkingSlots> parkingSlotsList) {
        this.parkingSlotsList = parkingSlotsList;
    }
}
