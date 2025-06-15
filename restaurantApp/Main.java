package restaurantApp;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Controller restController = new Controller();
        List<Restaurant> restaurantsList = Database.restaurantsList;
        restaurantsList.add(
                new Restaurant(
                        1,
                        "RestaurantA",
                        "121212",
                        "KA",
                        "Bangalore",
                        Arrays.asList("A", "B", "C")

                )
        );

        restaurantsList.add(
                new Restaurant(
                        2,
                        "RestaurantB",
                        "121212",
                        "KA",
                        "Bangalore",
                        List.of("D", "C")

                )
        );

        List<Restaurant> filterRestaurant = restController.
                filterRestaurant(
                        new FilterParam("RestaurantB", "121212", List.of("C", "D"))
                );

        System.out.println("Filtered restaurant: "+ filterRestaurant);
    }
}
