package practice;

import practice.entity.Command;
import practice.entity.ParkingLot;
import practice.service.ParkingLotService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        ParkingLotService parkingLotService = new ParkingLotService();

        Scanner scn = new Scanner(System.in);

//        create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
        while(true) {
//            String operation = scn.next();
//            if(operation.equals("create_parking_lot")) {
//                parkingLotService.createParkingLot(new ParkingLot(scn.next(), scn.nextInt(), scn.nextInt()));
//            }
            Command command = Command.getFromCommand(scn.next());
            ParkingLotService clone = (ParkingLotService) parkingLotService.clone();

            System.out.println("command "+ command);
            switch (command) {
                case CREATE_PARKING_LOT -> parkingLotService.createParkingLot(new ParkingLot(scn.next(), scn.nextInt(), scn.nextInt()));
                case DISPLAY -> System.out.println("display");
                case PARK_VEHICLE -> System.out.println("park vehicle");
                case UNPARK_VEHICLE -> System.out.println("unpark vehicle");
                case null -> {}
            }
        }
    }
}
