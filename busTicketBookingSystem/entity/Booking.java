package busTicketBookingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Booking {
//    List<User> user, Seat seat;
    private List<User> userList;
    private Ticket ticket;
}
