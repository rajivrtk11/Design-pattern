package busTicketBookingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
//    name, email, phoneNumber, password, username, city, state, paymentStatus
    private String name;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private String state;
    private String city;
}
