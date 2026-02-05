package movieticketbookingsystem.entities;

import java.util.List;

public class Cinema {
    String id;
    List<Screen> screens;
    City city;

    public Cinema(String id, List<Screen> screens, City city) {
        this.id = id;
        this.screens = screens;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Screen> getScreens() {
        return this.screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
