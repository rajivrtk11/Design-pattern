package practice.entity;

public class Vehicle {
    VehicleType vehicleType;
    String registrationNo;
    String color;
    String ticket;

    public Vehicle(VehicleType vehicleType, String registrationNo, String color, String ticket) {
        this.vehicleType = vehicleType;
        this.registrationNo = registrationNo;
        this.color = color;
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleType=" + vehicleType +
                ", registrationNo='" + registrationNo + '\'' +
                ", color='" + color + '\'' +
                ", ticket='" + ticket + '\'' +
                '}';
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
