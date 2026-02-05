package movieticketbookingsystem;

import movieticketbookingsystem.entities.*;
import movieticketbookingsystem.enums.PaymentStatus;
import movieticketbookingsystem.enums.SeatStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BookingService {
    Map<String, Cinema> cinema;
    Map<String, Show> shows;
    Map<String, City> city;
    Map<String, Movie> movie;

    public BookingService() {
        this.cinema = new ConcurrentHashMap<>();
        this.shows = new ConcurrentHashMap<>();;
        this.city = new ConcurrentHashMap<>();;
        this.movie = new ConcurrentHashMap<>();;
    }

    public void addCinema(String id, Cinema cinema) {
        this.cinema.put(id, cinema);
    }

    public void addShow(String id, Show show) {
        shows.put(id, show);
    }

    public void addCity(String id, City city) {
        this.city.put(id, city);
    }

    public void addMovie(String id, Movie movie) {
        this.movie.put(id, movie);
    }

    /*
    * 1. User will filter movie based on location and name
    *   -> He will get a list of shows.
    *   -> He will select the show
    *   -> He will select the seat
    * 2. He will book the ticket
    * 3. He will do the payment
    * 4. He will get the ticket.
    * */

    public List<Show> findShow(String movieName, City city) {
        List<Cinema> cinemaListBasedOnCity = cinema.values().stream()
                .filter(cin -> cin.getCity().getName().equalsIgnoreCase(city.getName()))
                .toList();

        List<Show> filteredShow = new ArrayList<>();
        for(Cinema cinema: cinemaListBasedOnCity) {
            List<Screen> screens = cinema.getScreens();
            for(Screen screen: screens) {
                List<Show> shows = screen.getShows();
                for(Show show : shows) {
                    if(show.getMovie().getName().equalsIgnoreCase(movieName)) {
                        filteredShow.add(show);
                    }
                }
            }
        }

        return filteredShow;
    }

    public List<Seat> getAvailableSeats(Show shows) {
        List<Seat> list = shows.getSeats().stream()
                .filter(seat -> seat.getStatus().equals(SeatStatus.AVAILABLE))
                .toList();
        return list;
    }

    public Booking bookTicket(List<Seat> seats, User user) {
        /*
        *  1. Calculate price
        *  2. Make payment
        *  3. Mark seat as book
        *  4. return ticket
        * */
        double amount = calculatePrice(seats);
        Payment payment = makePayment(amount);
        markSeatBooked(seats);

        return new Booking(
                UUID.randomUUID().toString(),
                user.getName(),
                payment,
                seats
        );
    }

    private double calculatePrice(List<Seat> seats) {
        double sum = seats.stream().mapToDouble(v -> v.getSeatType().getPrice()).sum();
        return sum;
    }

    private Payment makePayment(double amount ) {
        boolean paymentStatus = Math.random() > 0.05;
        return new Payment(
                UUID.randomUUID().toString(),
                paymentStatus ? PaymentStatus.SUCCESS : PaymentStatus.FAILED,
                "TXN_"+UUID.randomUUID().toString());
    }

    private void markSeatBooked(List<Seat> seats) {
        for(Seat seat: seats) {
            seat.setStatus(SeatStatus.BOOKED);
        }
    }
}
