package meetingRoomScheduler.controller;

import meetingRoomScheduler.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingController {
    public static void main(String[] args) {
        User admin = new User(1, "Rajiv", "rajivrtk11@gmail.com");
        List<User> participants = new ArrayList<>();
        participants.add(admin);
        participants.add(new User(2, "Sambit", "sambit@gmail.com"));
        participants.add(new User(3, "Ankit", "ankit.roy@gmail.com"));

        List<MeetingRoom> allRoom = new ArrayList<>();
        allRoom.add(new MeetingRoom(1, "Riyal", new ArrayList<>(), 3));
        allRoom.add(new MeetingRoom(2, "Bahat", new ArrayList<>(), 3));

        MeetingDetails meetingDetails = new MeetingDetails(1, "Daily standup", "Autopilot meeting");

        MeetingScheduler meetingScheduler = new MeetingScheduler(admin, participants, allRoom, meetingDetails);
        List<MeetingRoom> allRooms = meetingScheduler.getAllAvailableRooms(new Date(), new Date(System.currentTimeMillis()+30*60*1000), 3);

        Calender bookSlot = new Calender(new Date(), new Date(System.currentTimeMillis()+30*60*1000), meetingDetails);

        if(allRooms.size() > 1) {
            meetingScheduler.bookMeetingRoom(allRooms.get(0), bookSlot);
        }
        else {
            System.out.println("Room not available at given slot"+ bookSlot);
        }

        // book 2nd meeting
        allRooms = meetingScheduler.getAllAvailableRooms(new Date(), new Date(System.currentTimeMillis()+30*60*1000), 3);
//        System.out.println("all rooms" +allRooms);
        if(allRooms.size() >= 1) {
            meetingScheduler.bookMeetingRoom(allRooms.get(0), bookSlot);
        }
        else {
            System.out.println("Room not available at given slot"+ bookSlot);
        }

        // book 3rd meeting
        allRooms = meetingScheduler.getAllAvailableRooms(new Date(), new Date(System.currentTimeMillis()+30*60*1000), 3);

        if(allRooms.size() >= 1) {
            meetingScheduler.bookMeetingRoom(allRooms.get(0), bookSlot);
        }
        else {
            System.out.println("Room not available at given slot"+ bookSlot);
        }

        System.out.println(allRoom.toString());
    }
}
