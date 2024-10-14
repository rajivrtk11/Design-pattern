package parkingLot2.Model;

public class Vehicle extends BaseModel {
    private String number;
    private VehicleType vehicleType;

    @Override
    public String toString() {
        return "Vehicle{" +
                "number=" + (number != null ? number : "null") +
                ", vehicleType=" + (vehicleType != null ? vehicleType.toString() : "null") +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
