package bookmyshow.models;

import java.util.List;

public class Theater {
    private String id;
    private String state;
    private String district;
    private String pin;
    private List<Show> showList;

    public Theater(String id, String state, String district, String pin, List<Show> showList) {
        this.id = id;
        this.state = state;
        this.district = district;
        this.pin = pin;
        this.showList = showList;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", district='" + district + '\'' +
                ", pin='" + pin + '\'' +
                ", showList=" + showList +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
