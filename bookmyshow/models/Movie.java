package bookmyshow.models;

import java.time.LocalDateTime;

public class Movie {
    private String id;
    private String name;
    private LocalDateTime listingDate;

    public Movie(String id, String name, LocalDateTime listingDate) {
        this.id = id;
        this.name = name;
        this.listingDate = listingDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", listingDate=" + listingDate +
                '}';
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

    public LocalDateTime getListingDate() {
        return listingDate;
    }

    public void setListingDate(LocalDateTime listingDate) {
        this.listingDate = listingDate;
    }
}
