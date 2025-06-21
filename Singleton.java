import java.util.PriorityQueue;

public class Singleton {
    public static void main(String[] args) {
//        [-2,1,-3,4,-1,12,11,-56,40]
        int[] arr = new int[] { -2,1,-3,4,-1,12,11,-56,40 };

        int sum = -(int)1e9;
        int runningSum = 0;

        for(int i = 0; i < arr.length; i++) {
            runningSum += arr[i];

            sum = Math.max(sum, runningSum);
            if(runningSum < 0) {
                runningSum = 0;
            }
        }

        System.out.println(sum);
    }
    // 1. Show all the tickets for the bus
    // 2. Make the booking

    // User, Bus, Seat, Booking, Payment
    // User => name, email, phoneNumber, password, username, city, state, paymentStatus
    // Bus => id, registrationNumber, Name, totalSeat, vaccantSeat, filledSeat, price
    // Seat => id, issueDate, journeyDate, busNumber,
    // Booking => List<User> user, Seat ticket;
    // Payment => json payload, response code, json response, status(Succeed/Failed)


}
