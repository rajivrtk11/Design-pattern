package ParkingLot.Controller;

import ParkingLot.DataTransferObject.IssueTicketRequestDTO;
import ParkingLot.DataTransferObject.IssueTicketResponseDTO;
import ParkingLot.Model.Ticket;
import ParkingLot.Services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController() {
        this.ticketService = new TicketService();
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO request) {
        Ticket ticket = ticketService.issueTicket(request.getVehicleType(), request.getVehicleNumber(), request.getGateId());
        IssueTicketResponseDTO response = new IssueTicketResponseDTO();

        response.setTicket(ticket);
        return response;
    }
}
