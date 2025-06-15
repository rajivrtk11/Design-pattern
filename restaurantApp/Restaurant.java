package restaurantApp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Restaurant {
    private int id;
    private String name;
    private String pincode;
    private String state;
    private String city;
    private List<String> food;

}

