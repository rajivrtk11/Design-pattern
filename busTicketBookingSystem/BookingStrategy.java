package busTicketBookingSystem;

import busTicketBookingSystem.entity.Booking;
import busTicketBookingSystem.entity.Bus;
import busTicketBookingSystem.entity.User;

import java.util.Map;

public interface BookingStrategy {
    Booking bookTicket(Map<String, User> busSeatUserMap, Bus bus );
}
