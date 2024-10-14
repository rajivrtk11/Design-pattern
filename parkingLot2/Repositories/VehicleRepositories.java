package parkingLot2.Repositories;

import parkingLot2.Model.Vehicle;

import java.util.Optional;

public class VehicleRepositories {

    public Optional<Vehicle> getVehicleByNumber(String number) {
        return Optional.empty();
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return new Vehicle();
    }
}
