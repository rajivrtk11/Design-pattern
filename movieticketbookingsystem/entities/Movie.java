package movieticketbookingsystem.entities;

import java.time.LocalDateTime;

public class Movie {
    String id;
    String name;
    LocalDateTime releaseDate;
    int durationInMinutes;

    public Movie(String id, String name, LocalDateTime releaseDate, int durationInMinutes) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.durationInMinutes = durationInMinutes;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
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

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }
}
