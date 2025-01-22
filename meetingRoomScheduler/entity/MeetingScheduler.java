package meetingRoomScheduler.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MeetingScheduler {
    User admin;
    List<User> participants;
    List<MeetingRoom> allRooms;
    MeetingDetails meetingDetails;

    // 1. Add list of rooms
    // 2. Get available meeting rooms
    // 3. Book any room for give time slot
    // 4. Send notification to all the participants


    public void addRooms(MeetingRoom room) {
        allRooms.add(room);
    }

    public List<MeetingRoom> getAllAvailableRooms(Date startDate, Date endDate, int capacity) {
        List<MeetingRoom> availableMeetingRooms = new ArrayList<>();

        Boolean[] isAvailable = new Boolean[allRooms.size()];
        Arrays.fill(isAvailable, true);

        for(int i = 0; i < allRooms.size(); i++) {
            MeetingRoom currRoom = allRooms.get(i);
            
            // take the booked slot and iterate for any over lapping
            List<Calender> bookedSlots = currRoom.getBookedSlots();
            for(int j = 0; j < bookedSlots.size(); j++) {
                Calender calender = bookedSlots.get(j);
                if((calender.startTime.after(startDate) && calender.startTime.before(endDate) ||
                        calender.endTime.after(startDate) && calender.endTime.before(endDate)) ||
                        (startDate.after(calender.startTime) && startDate.before(calender.endTime)) ||
                        (endDate.after(calender.startTime) && endDate.before(calender.endTime)) ||
                        (startDate.equals(calender.startTime) && endDate.equals(calender.endTime))

                ) {
                    isAvailable[i] = false;
                }
            }

        }

        for(int i = 0; i < allRooms.size(); i++) {
            if(isAvailable[i]) {
                availableMeetingRooms.add(allRooms.get(i));
            }
        }

        return availableMeetingRooms;
    }

    public void bookMeetingRoom(MeetingRoom meetingRoom, Calender calender) {
        meetingRoom.bookedSlots.add(calender);
        notifyUsers();
    }

    private void notifyUsers() {
        for(User user: participants) {
            System.out.println("Notification sent to "+user.name);
        }
    }

    public MeetingScheduler(User admin, List<User> participants, List<MeetingRoom> allRooms, MeetingDetails meetingDetails) {
        this.admin = admin;
        this.participants = participants;
        this.allRooms = allRooms;
        this.meetingDetails = meetingDetails;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public List<MeetingRoom> getAllRooms() {
        return allRooms;
    }

    public void setAllRooms(List<MeetingRoom> allRooms) {
        this.allRooms = allRooms;
    }

    public MeetingDetails getMeetingDetails() {
        return meetingDetails;
    }

    public void setMeetingDetails(MeetingDetails meetingDetails) {
        this.meetingDetails = meetingDetails;
    }
}
