package restaurantApp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FilterParam {
    private String name;
    private String pincode;
    private List<String> food;

    /*
    * if only name;
    *   filter on name;
    * if only pincode
    *   filter on pincode
    * if only food
    *   filter on food.
    *
    * if name, pincode and food all available filter on all the given criteria.
    * */
}
