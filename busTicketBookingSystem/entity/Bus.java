package busTicketBookingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Bus {
//    id, registrationNumber, Name, totalSeat, vaccantSeat, filledSeat, price
    private String id;
    private String registrationNUmber;
    private String name;
    private int totalSeat;
    private int vaccantSeat;
    private int filledSeat;
    private float price;
    private List<Seat> seatList;
}
