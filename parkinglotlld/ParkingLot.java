package parkinglotlld;

import parkinglotlld.entities.ParkingFloor;
import parkinglotlld.entities.ParkingSpot;
import parkinglotlld.entities.ParkingTicket;
import parkinglotlld.entities.Vehicle;
import parkinglotlld.strategies.fee.FeeStrategy;
import parkinglotlld.strategies.fee.FlatRateFeeStrategy;
import parkinglotlld.strategies.parking.BestFitStrategy;
import parkinglotlld.strategies.parking.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    static ParkingLot instance;
    List<ParkingFloor> floors = new ArrayList<>();
    Map<String, ParkingTicket> activeTickets;
    FeeStrategy feeStrategy;
    ParkingStrategy parkingStrategy;

    private ParkingLot() {
        this.activeTickets = new ConcurrentHashMap<>();
        this.feeStrategy = new FlatRateFeeStrategy();
        this.parkingStrategy = new BestFitStrategy();
    }

    public static synchronized ParkingLot getInstance() {
        if(instance == null) {
            instance = new ParkingLot();
        }

        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {
        Optional<ParkingSpot> availableSpot = parkingStrategy.findSpot(floors, vehicle);

        if(availableSpot.isPresent()) {
            ParkingSpot spot = availableSpot.get();
            spot.parkVehicle(vehicle);

            ParkingTicket ticket = new ParkingTicket(vehicle, spot);
            activeTickets.put(vehicle.getRegistrationNumber(), ticket);
            System.out.printf("%s parked at %s. Ticket: %s\n", vehicle.getRegistrationNumber(), spot.getSpotId(), ticket.getTicketId());
            return Optional.of(ticket);
        }

        System.out.println("No available spot for "+ vehicle.getRegistrationNumber());
        return Optional.empty();
    }

    public Optional<Double> unparkVehicle(String licenseNumber) {
        ParkingTicket ticket = activeTickets.remove(licenseNumber);
        if(ticket == null) {
            System.out.println("Ticket not found");
            return Optional.empty();
        }

        ticket.setExitTimestamp();
        ticket.getSpot().unparkVehicle();

        double parkingFee = feeStrategy.calculateFee(ticket);

        return Optional.of(parkingFee);
    }
}
