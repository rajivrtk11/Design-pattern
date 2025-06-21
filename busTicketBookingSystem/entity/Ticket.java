package busTicketBookingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Ticket {
    private String id;
    private LocalDateTime issueDate;
    private LocalDateTime journeyDate;
    private String busNumber;
    private List<Seat> seatList;
    private float price;
}
