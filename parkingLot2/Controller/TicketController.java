package parkingLot2.Controller;

import parkingLot2.DataTransferObject.IssueTicketRequestDTO;
import parkingLot2.DataTransferObject.IssueTicketResponseDTO;
import parkingLot2.DataTransferObject.ResponseStatus;
import parkingLot2.Model.Ticket;
import parkingLot2.Services.TicketService;

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
