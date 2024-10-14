package ParkingLot;

import ParkingLot.Controller.TicketController;
import ParkingLot.DataTransferObject.IssueTicketRequestDTO;
import ParkingLot.DataTransferObject.IssueTicketResponseDTO;
import ParkingLot.Model.VehicleType;
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
        IssueTicketRequestDTO req = new IssueTicketRequestDTO();

        req.setGateId(1L);
        req.setVehicleType(VehicleType.SUV);
        req.setVehicleNumber("HR12A0001");
        IssueTicketResponseDTO issuedTicket = ticketController.issueTicket(req);
        System.out.println("Issued ticket "+ issuedTicket.toString());
    }
}
