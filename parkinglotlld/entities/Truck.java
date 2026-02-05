package parkinglotlld.entities;

import parkinglotlld.enums.VehicleSize;

public class Truck extends Vehicle{
    public Truck(String registrationNumber) {
        super(registrationNumber, VehicleSize.LARGE);
    }
}
