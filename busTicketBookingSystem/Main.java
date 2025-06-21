package busTicketBookingSystem;

import busTicketBookingSystem.entity.*;
import java.util.HashMap;
import java.util.Map;

import static busTicketBookingSystem.Repository.availableBus;
import static busTicketBookingSystem.Repository.usersList;

public class Main {
    public static void main(String[] args) {
        // 1. Show all the tickets for the bus
        // 2. Make the booking

        // User, Bus, Seat, Booking, Payment
        // User => name, email, phoneNumber, password, username, city, state, paymentStatus
        // Bus => id, registrationNumber, Name, totalSeat, vaccantSeat, filledSeat, price
        // Seat => id, issueDate, journeyDate, busNumber,
        // Booking => List<User> user, Seat ticket;
        // Payment => json payload, response code, json response, status(Succeed/Failed)
//        System.out.println("Hello world");

        User user1 = new User(
                "Rajiv",
                "rajivrtk11@gmail.com",
                "rajivrtk11",
                "Rr11212",
                "12121212",
                "Karnataka",
                "bangalore"
        );
        usersList.add(user1);

        BookingStrategy bookingStrategy = new DefaultBooking();
        TicketBookingSystem ticketBookingSystem = new TicketBookingSystem(bookingStrategy);

        Map<String, User> seatNumberUserMap = new HashMap<>();
        seatNumberUserMap.put("1", user1);
        seatNumberUserMap.put("2", user1);
        seatNumberUserMap.put("3", user1);
//        seatNumberUserMap.put("4", user1);
//        seatNumberUserMap.put("5", user1);

        Booking booking = ticketBookingSystem.bookTicket(seatNumberUserMap, availableBus.get(0));

        System.out.println("Booking is "+ booking);
    }

}
