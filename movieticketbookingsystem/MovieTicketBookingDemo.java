package movieticketbookingsystem;

import movieticketbookingsystem.entities.*;
import movieticketbookingsystem.enums.SeatStatus;
import movieticketbookingsystem.enums.SeatType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieTicketBookingDemo {
    public static void main(String[] args) {
       // Make object of bookingservice
        BookingService bookingService = new BookingService();

        // Add city
        System.out.println("Adding city into database");
        City del = new City("del", "Delhi");
        City blr = new City("blr", "Bengalore");

        bookingService.addCity("del", del);
        bookingService.addCity("blr", blr);

        // Add Movie
        LocalDateTime releaseDate = LocalDateTime.of(2026, 2, 5, 0, 0, 0);
        Movie avenger = new Movie("avenger", "Avenger: End game", releaseDate, 120);
        Movie matrix = new Movie("mat", "Matrix", releaseDate, 120);

        bookingService.addMovie("avenger", avenger);
        bookingService.addMovie("matrix", matrix);

        // Make seat
        List<Seat> seats = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            seats.add(new Seat("A"+1, 1, i, i < 5 ? SeatType.REGULAR : SeatType.RECLINER, SeatStatus.AVAILABLE));
        }

        LocalDateTime showTime = LocalDateTime.of(2026, 2, 5, 3, 0, 0);
        Show eveningShow = new Show("show-1", "Evening Show", avenger, showTime, seats);

        List<Seat> seats1 = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            seats1.add(new Seat("A"+1, 1, i, i < 5 ? SeatType.REGULAR : SeatType.RECLINER, SeatStatus.AVAILABLE));
        }

        LocalDateTime nightShowTime = LocalDateTime.of(2026, 2, 5, 9, 0, 0);
        Show nightShow = new Show("show-2", "Night Show", matrix, nightShowTime, seats1);

        // Add show
        bookingService.addShow("show-1", eveningShow);
        bookingService.addShow("show-2", nightShow);

        // Add Screen
        Screen screen1 = new Screen("screen-1", "Bigger screen", List.of(eveningShow));

        // Add cinema
        Cinema cinema = new Cinema("cinema-1", List.of(screen1), blr);
        bookingService.addCinema("cinema-1", cinema);

        // Make User
        User rajivSingh = new User("user-1", "Rajiv singh", "rajivrtk01@gmail.com");

        // Search show based on location and movie name
        List<Show> show = bookingService.findShow("Avenger: End game", blr);
        System.out.println("Shows available in bangalore for Avenger: End game "+ show.size());

        if(show.size() == 0) {
            System.out.println("No shows are available for Avenger: End game and Bangalore");

        }
        List<Seat> availableSeats = bookingService.getAvailableSeats(show.get(0));

        System.out.println("Available seats "+ availableSeats.size());

        if(availableSeats.size() == 0) {
            System.out.println("Seats are not available for given show");
        }

        List<Seat> desiredSeats = List.of(availableSeats.get(0), availableSeats.get(1));
        Booking booking = bookingService.bookTicket(desiredSeats, rajivSingh);

        System.out.println("Booking of Rajiv singh is "+ booking);

        List<Seat> availableSeatsAfterBooking = bookingService.getAvailableSeats(show.get(0));

        System.out.println("Available seats "+ availableSeatsAfterBooking.size());
    }
}
