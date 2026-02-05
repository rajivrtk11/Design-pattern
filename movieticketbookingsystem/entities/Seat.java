package movieticketbookingsystem.entities;

import movieticketbookingsystem.enums.SeatStatus;
import movieticketbookingsystem.enums.SeatType;

import java.util.UUID;

public class Seat {
    String id;
    int row;
    int col;
    SeatType seatType;
    SeatStatus status;

    public Seat(String id, int row, int col, SeatType seatType, SeatStatus status) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.seatType = seatType;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id='" + id + '\'' +
                ", row=" + row +
                ", col=" + col +
                ", seatType=" + seatType +
                ", status=" + status +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
