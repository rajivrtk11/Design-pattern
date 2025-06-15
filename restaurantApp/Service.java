package restaurantApp;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Service {
    List<Restaurant> restaurantsList = Database.restaurantsList;

    public List<Restaurant> filterRestaurant(FilterParam param) {
        return restaurantsList.stream()
                .filter(restaurant ->
                        (param.getName() == null || param.getName().isEmpty() || restaurant.getName().equals(param.getName())) &&
                        (param.getPincode() == null || param.getPincode().isEmpty() || restaurant.getPincode().equals(param.getPincode())) &&
                        (param.getFood() == null || param.getFood().isEmpty() || param.getFood().stream().anyMatch(food -> restaurant.getFood().contains(food)))
                )
                .collect(Collectors.toList());
    }

    private void filterFood() {

    }

}
