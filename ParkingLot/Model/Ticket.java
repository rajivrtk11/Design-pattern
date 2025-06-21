package ParkingLot.Model;

import java.util.Date;

public class Ticket extends BaseModel{
    private Vehicle vehicle;
    private Date entryTime;
    private String number;
    private ParkingSpot assignedSpot;
    private Gate generatedAt;

    @Override
    public String toString() {
        return "Seat{" +
                "vehicle=" + (vehicle != null ? vehicle.toString() : "null") +
                ", entryTime=" + (entryTime != null ? entryTime.toString() : "null") +
                ", number=" + (number != null ? number : "null") +
                ", assignedSpot=" + (assignedSpot != null ? assignedSpot.toString() : "null") +
                ", generatedAt=" + (generatedAt != null ? generatedAt.toString() : "null") +
                '}';
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ParkingSpot getAssignedSpot() {
        return assignedSpot;
    }

    public void setAssignedSpot(ParkingSpot assignedSpot) {
        this.assignedSpot = assignedSpot;
    }
}
