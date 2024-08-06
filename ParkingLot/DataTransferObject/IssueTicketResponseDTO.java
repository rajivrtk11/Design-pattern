package ParkingLot.DataTransferObject;

import ParkingLot.Model.Ticket;

public class IssueTicketResponseDTO {
    private Ticket ticket;
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
