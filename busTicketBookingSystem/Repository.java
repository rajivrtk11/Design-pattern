package busTicketBookingSystem;

import busTicketBookingSystem.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {
    public static List<User> usersList = new ArrayList<>();
    public static List<Booking> bookingList = new ArrayList<>();
    public static List<Bus> availableBus = Arrays.asList(
            new Bus(
                    "1",
                    "KA 04 pq 7777",
                    "Bus A",
                    40,
                    40,
                    0,
                    20,
                    Arrays.asList(
                            new Seat("1", SeatState.FILLED, null),
                            new Seat("2", SeatState.VACCANT, null),
                            new Seat("3", SeatState.VACCANT, null),
                            new Seat("4", SeatState.VACCANT, null)
                    )
            ),
            new Bus(
                    "2",
                    "KA 04 pq 7778",
                    "Bus B",
                    4,
                    4,
                    0,
                    20,
                    Arrays.asList(
                            new Seat("1", SeatState.FILLED, null),
                            new Seat("2", SeatState.VACCANT, null),
                            new Seat("3", SeatState.VACCANT, null),
                            new Seat("4", SeatState.VACCANT, null)
                    )
            )
    );
}
