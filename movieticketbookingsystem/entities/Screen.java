package movieticketbookingsystem.entities;

import java.util.List;

public class Screen {
    String id;
    String name;
    List<Show> shows;

    public Screen(String id, String name, List<Show> shows) {
        this.id = id;
        this.name = name;
        this.shows = shows;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
