package parkinglotlld.entities;

import parkinglotlld.enums.VehicleSize;

import java.util.UUID;

public class Vehicle {
    String id;
    String registrationNumber;
    VehicleSize size;

    public Vehicle(String registrationNumber, VehicleSize size) {
        this.id = UUID.randomUUID().toString();
        this.registrationNumber = registrationNumber;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void setSize(VehicleSize size) {
        this.size = size;
    }
}
