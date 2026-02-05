package bookmyshow.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Show {
    private String id;
    private Movie movie;
    private List<Seat> seatList;
    private int totalSeat;
    private int bookedSeat;
    private LocalDateTime start;
    private LocalDateTime end;

    public Show(String id, Movie movie, List<Seat> seatList, int totalSeat, int bookedSeat, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.movie = movie;
        this.seatList = seatList;
        this.totalSeat = totalSeat;
        this.bookedSeat = bookedSeat;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id='" + id + '\'' +
                ", movie=" + movie +
                ", seatList=" + seatList +
                ", totalSeat=" + totalSeat +
                ", bookedSeat=" + bookedSeat +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public int getBookedSeat() {
        return bookedSeat;
    }

    public void setBookedSeat(int bookedSeat) {
        this.bookedSeat = bookedSeat;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
