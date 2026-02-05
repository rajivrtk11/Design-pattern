package movieticketbookingsystem.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Show {
    String id;
    String name;
    Movie movie;
    List<Seat> seats;
    LocalDateTime startTime;

    public Show(String id, String name, Movie movie, LocalDateTime startTime, List<Seat> seats) {
        this.id = id;
        this.name = name;
        this.movie = movie;
        this.startTime = startTime;
        this.seats = seats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
