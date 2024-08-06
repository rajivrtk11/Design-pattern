package ParkingLot.Controller;

import ParkingLot.DataTransferObject.IssueTicketRequestDTO;
import ParkingLot.DataTransferObject.IssueTicketResponseDTO;
import ParkingLot.DataTransferObject.ResponseStatus;
import ParkingLot.Model.Ticket;
import ParkingLot.Repositories.GateRepositories;
import ParkingLot.Repositories.TicketRepositories;
import ParkingLot.Repositories.VehicleRepositories;
import ParkingLot.Services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO request) {
        IssueTicketResponseDTO response = new IssueTicketResponseDTO();
        try {
            Ticket ticket = ticketService.issueTicket(request.getVehicleType(), request.getVehicleNumber(), request.getGateId());

            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setTicket(ticket);
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
