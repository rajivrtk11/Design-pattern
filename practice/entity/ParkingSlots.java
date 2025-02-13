package practice.entity;


public class ParkingSlots {
    Vehicle vehicle;
    boolean isFree;
    int slotId;

    public ParkingSlots(Vehicle vehicle, boolean isFree, int slotId) {
        this.vehicle = vehicle;
        this.isFree = isFree;
        this.slotId = slotId;
    }

    @Override
    public String toString() {
        return "ParkingSlots{" +
                "vehicle=" + vehicle +
                ", isFree=" + isFree +
                ", slotId=" + slotId +
                '}';
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
