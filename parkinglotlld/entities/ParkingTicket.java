package parkinglotlld.entities;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket {
    String ticketId;
    Vehicle vehicle;
    ParkingSpot spot;
    long entryTimestamp;
    long exitTimestamp;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTimestamp = new Date().getTime();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public long getEntryTimestamp() {
        return entryTimestamp;
    }

    public long getExitTimestamp() {
        return exitTimestamp;
    }

    public void setExitTimestamp() {
        this.exitTimestamp = new Date().getTime();
    }
}
