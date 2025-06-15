package restaurantApp;


import java.util.List;

public class Controller {
    private List<Restaurant> db;
    private Service service;

    Controller() {
        this.db = Database.restaurantsList;
        this.service = new Service();
    }

    public void addRestaurant(Restaurant restaurant) {
        db.add(restaurant);
    }

    public List<Restaurant> filterRestaurant(FilterParam param) {
        return this.service.filterRestaurant(param);
    }
}
