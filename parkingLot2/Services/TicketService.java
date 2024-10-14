package parkingLot2.Services;

import parkingLot2.Exceptions.GateNotFoundException;
import parkingLot2.Model.Gate;
import parkingLot2.Model.Ticket;
import parkingLot2.Model.Vehicle;
import parkingLot2.Model.VehicleType;
import parkingLot2.Repositories.GateRepositories;
import parkingLot2.Repositories.TicketRepositories;
import parkingLot2.Repositories.VehicleRepositories;
import parkingLot2.Strategy.SpotAssignmentStrategy.SpotAssignmentStrategy;
import parkingLot2.Strategy.SpotAssignmentStrategy.SpotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepositories gateRepositories;
    private VehicleRepositories vehicleRepositories;
    private TicketRepositories ticketRepositories;

    public TicketService(GateRepositories gateRepositories,
                         VehicleRepositories vehicleRepositories,
                         TicketRepositories ticketRepositories) {
        this.ticketRepositories = ticketRepositories;
        this.vehicleRepositories = vehicleRepositories;
        this.gateRepositories = gateRepositories;
    }

    /**
     * 1. Create a ticket object
     * 2. Assign spot
     * 3. Return that object
     *
     * For vehicle creation part
     * 1. Check if vehicle is already is in DB
     * 2. Yes: Get the vehicle from DB and add it to the ticket.
     * 3. No: Create New Vehicle, save it to DB, and now add it to the Ticket.
     */
    public Ticket issueTicket(VehicleType vehicleType, String vehicleNumber, Long gateId) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> gateOptional = gateRepositories.FindGateByID(gateId);
        if (gateOptional.isEmpty()) {
            throw new GateNotFoundException();
        }
        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);

        Optional<Vehicle> vehicleOptional = vehicleRepositories.getVehicleByNumber(vehicleNumber);
        Vehicle savedVehicle;
        if (vehicleOptional.isEmpty()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicleRepositories.saveVehicle(vehicle);
        } else {
            savedVehicle = vehicleOptional.get();
        }
        ticket.setVehicle(savedVehicle);

        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpot(gate, vehicleType);
        ticket.setAssignedSpot(spotAssignmentStrategy.getSpot(gate, vehicleType));

        ticket.setNumber(vehicleNumber);

        // before returning ticket save in DB
        return ticketRepositories.saveTicket(ticket);
    }
}
