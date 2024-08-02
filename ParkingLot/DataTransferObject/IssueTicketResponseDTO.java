package ParkingLot.DataTransferObject;

import ParkingLot.Model.Ticket;

public class IssueTicketResponseDTO {
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
