package practice.entity;

import java.util.Objects;

public enum Command {
//    create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
//    park_vehicle <vehicle_type> <reg_no> <color>
//    unpark_vehicle <ticket_id>
//    display <display_type> <vehicle_type>
//    Possible values of display_type: free_count, free_slots, occupied_slots
//            exit
    CREATE_PARKING_LOT("create_parking_lot"),
    PARK_VEHICLE("park_vehicle"),
    UNPARK_VEHICLE("unpark_vehicle"),
    DISPLAY("display");

    String command;
    Command(String command) {
        this.command = command;
    }

    public String getCommand(){
        return this.command;
    }

    public static Command getFromCommand(String command) {
        for(Command c : values()) {
            if(Objects.equals(c.command, command)) return c;
        }

        return null;
    }
}
