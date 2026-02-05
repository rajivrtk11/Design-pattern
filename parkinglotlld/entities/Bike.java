package parkinglotlld.entities;

import parkinglotlld.enums.VehicleSize;

public class Bike extends Vehicle{
    public Bike(String registrationNumber) {
        super(registrationNumber,VehicleSize.SMALL);
    }
}
