package parkinglotlld.strategies.fee;

import parkinglotlld.entities.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket parkingTicket);
}
