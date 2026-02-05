package parkinglotlld.entities;

import parkinglotlld.enums.VehicleSize;

public class Car extends Vehicle{
    public Car(String registrationNumber) {
        super(registrationNumber, VehicleSize.MEDIUM);
    }
}
