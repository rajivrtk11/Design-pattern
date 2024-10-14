package parkingLot2;

import parkingLot2.Controller.TicketController;
import parkingLot2.DataTransferObject.IssueTicketRequestDTO;
import parkingLot2.DataTransferObject.IssueTicketResponseDTO;
import parkingLot2.Model.VehicleType;
import parkingLot2.Repositories.GateRepositories;
import parkingLot2.Repositories.TicketRepositories;
import parkingLot2.Repositories.VehicleRepositories;
import parkingLot2.Services.TicketService;

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

        // generate bill


    }
}
