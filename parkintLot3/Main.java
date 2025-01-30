package parkintLot3;

import parkintLot3.entity.Command;
import parkintLot3.entity.DisplayType;
import parkintLot3.entity.ParkingLot;
import parkintLot3.entity.VehicleType;
import parkintLot3.services.ParkingLotService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();

        while (true) {
            Scanner scan = new Scanner(System.in);
            Command type = Command.of(scan.next());
            switch (type) {
                case CREATE_PARKING_LOT -> {
                    parkingLotService.createParkingLot(new ParkingLot(scan.next(), scan.nextInt(), scan.nextInt()));
                }
                case PARK_VEHICLE -> parkingLotService.parkVehicle(VehicleType.valueOf(scan.next()), scan.next(), scan.next());
                case UNPARK_VEHICLE -> parkingLotService.unParkVehicle(scan.next());
                case DISPLAY -> parkingLotService.display(DisplayType.of(scan.next()), VehicleType.valueOf(scan.next()));
                case EXIT -> {
                    return;
                }
            }
        }
    }
}
//create_parking_lot PR1234 2 6
//display free_count CAR
//display free_count BIKE
//display free_count TRUCK
//display free_slots CAR
//display free_slots BIKE
//display free_slots TRUCK
//display occupied_slots CAR
//display occupied_slots BIKE
//display occupied_slots TRUCK
//park_vehicle CAR KA-01-DB-1234 black
//park_vehicle CAR KA-02-CB-1334 red
//park_vehicle CAR KA-01-DB-1133 black
//park_vehicle CAR KA-05-HJ-8432 white
//park_vehicle CAR WB-45-HO-9032 white
//park_vehicle CAR KA-01-DF-8230 black
//park_vehicle CAR KA-21-HS-2347 red
//display free_count CAR
//display free_count BIKE
//display free_count TRUCK
//unpark_vehicle PR1234_2_5
//unpark_vehicle PR1234_2_5
//unpark_vehicle PR1234_2_7
//display free_count CAR
//display free_count BIKE
//display free_count TRUCK
//display free_slots CAR
//display free_slots BIKE
//display free_slots TRUCK
//display occupied_slots CAR
//display occupied_slots BIKE
//display occupied_slots TRUCK
//park_vehicle BIKE KA-01-DB-1541 black
//park_vehicle TRUCK KA-32-SJ-5389 orange
//park_vehicle TRUCK KL-54-DN-4582 green
//park_vehicle TRUCK KL-12-HF-4542 green
//display free_count CAR
//display free_count BIKE
//display free_count TRUCK
//display free_slots CAR
//display free_slots BIKE
//display free_slots TRUCK
//display occupied_slots CAR
//display occupied_slots BIKE
//display occupied_slots TRUCK
//        exit