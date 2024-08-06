package ParkingLot;

import ParkingLot.Controller.TicketController;
import ParkingLot.Repositories.GateRepositories;
import ParkingLot.Repositories.TicketRepositories;
import ParkingLot.Repositories.VehicleRepositories;
import ParkingLot.Services.TicketService;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepositories gateRepositories = new GateRepositories();
        VehicleRepositories vehicleRepositories = new VehicleRepositories();
        TicketRepositories ticketRepositories = new TicketRepositories();

        TicketService ticketService = new TicketService(gateRepositories, vehicleRepositories, ticketRepositories);
        TicketController ticketController = new TicketController(ticketService);
    }
}
