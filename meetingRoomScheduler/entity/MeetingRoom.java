package meetingRoomScheduler.entity;


import java.util.List;

public class MeetingRoom {
    int id;
    String name;
    List<Calender> bookedSlots;
    int capacity;

    public MeetingRoom(int id, String name, List<Calender> bookedSlots, int capacity) {
        this.id = id;
        this.name = name;
        this.bookedSlots = bookedSlots;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookedSlots=" + bookedSlots +
                ", capacity=" + capacity +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Calender> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(List<Calender> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
