package busTicketBookingSystem;

import busTicketBookingSystem.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static busTicketBookingSystem.Repository.bookingList;

public class DefaultBooking implements BookingStrategy {

    // seat index is suppose to get 0 bases
    @Override
    public Booking bookTicket(Map<String, User> busSeatUserMap, Bus bus) {
        // check the state of the ticket id in bus. Book if available
        // if not available find first vaccant seat and book
        // if not available return no ticket available;

        List<User> userList = new ArrayList<>();
        List<Seat> bookedSeat = new ArrayList<>();
        float sumOfPrice = 0;

        for (Map.Entry<String, User> entry : busSeatUserMap.entrySet()) {
            String seatNumber = entry.getKey();
            User user = entry.getValue();

            userList.add(user);
            if(!isSeatAvailable(seatNumber, bus) || findFirstVaccantSeat(bus) == null) {
                throw new IllegalArgumentException("Seat is not available in the bus.");
            }

            if(isSeatAvailable(seatNumber, bus)) {
                Seat seat = bus.getSeatList().get(Integer.parseInt(seatNumber));
                seat.setUser(user);
                seat.setSeatState(SeatState.FILLED);
                bookedSeat.add(seat);
            }
            else {
                Seat firstVaccantSeat = findFirstVaccantSeat(bus);
                bookSeat(user, firstVaccantSeat);
                bookedSeat.add(firstVaccantSeat);
            }

            bus.setVaccantSeat(bus.getVaccantSeat()-1);
            bus.setFilledSeat(bus.getFilledSeat()+1);
            sumOfPrice += bus.getPrice();
        }

        int size = bookingList.size()+1;

        Ticket ticket = Ticket.builder().id(size + "")
                .issueDate(LocalDateTime.now())
                .journeyDate(LocalDateTime.now())
                .busNumber(bus.getRegistrationNUmber())
                .seatList(bookedSeat)
                .price(sumOfPrice).build();

        Booking booking = new Booking(
                userList,
                ticket
        );

        bookingList.add(booking);
        return booking;
    }

    private boolean isSeatAvailable(String seatNumber, Bus bus) {
        if(bus.getSeatList().size() <= Integer.parseInt(seatNumber)) return false;

       return bus.getSeatList()
               .get(Integer.parseInt(seatNumber))
               .getSeatState().equals(SeatState.VACCANT);
    }

    private Seat findFirstVaccantSeat(Bus bus) {
       return bus.getSeatList().stream()
               .filter((seat) -> seat.getSeatState().equals(SeatState.VACCANT))
               .findFirst()
               .orElseThrow(() -> new IllegalArgumentException("Vacant seat not found"));
    }

    private Seat bookSeat(User user, Seat seat) {
        seat.setUser(user);
        seat.setSeatState(SeatState.FILLED);
        return seat;
    }
}
