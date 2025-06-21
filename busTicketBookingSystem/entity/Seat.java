package busTicketBookingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Seat {
//    id, issueDate, journeyDate, busNumber,
    private String id;
    private SeatState seatState;
    private User user;
}

