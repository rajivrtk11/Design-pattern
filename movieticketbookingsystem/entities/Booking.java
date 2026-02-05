package movieticketbookingsystem.entities;

import java.util.List;

public class Booking {
    String id;
    String suer;
    Payment payment;
    List<Seat> seats;

    public Booking(String id, String suer, Payment payment, List<Seat> seats) {
        this.id = id;
        this.suer = suer;
        this.payment = payment;
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

    public String getSuer() {
        return suer;
    }

    public void setSuer(String suer) {
        this.suer = suer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", suer='" + suer + '\'' +
                ", payment=" + payment +
                ", seats=" + seats +
                '}';
    }
}
