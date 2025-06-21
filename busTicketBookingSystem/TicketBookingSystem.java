package busTicketBookingSystem;

import busTicketBookingSystem.entity.Booking;
import busTicketBookingSystem.entity.Bus;
import busTicketBookingSystem.entity.User;

import lombok.Data;

import java.util.Map;

import static busTicketBookingSystem.Repository.availableBus;
import static busTicketBookingSystem.Repository.usersList;

@Data
public class TicketBookingSystem {
    private BookingStrategy bookingStrategy;

    public TicketBookingSystem(BookingStrategy bookingStrategy) {
        this.bookingStrategy = bookingStrategy;
    }

    public void addUser(User user) {
        usersList.add(user);
    }

    public void addBus(Bus bus) {
        availableBus.add(bus);
    }

    public Booking bookTicket(Map<String, User> busSeatUserMap, Bus bus ) {
        return this.bookingStrategy.bookTicket(busSeatUserMap, bus);
    }
}
