package meetingRoomScheduler.entity;

import java.util.Date;

public class Calender {
    Date startTime;
    Date endTime;

    public Calender(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Calender{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
