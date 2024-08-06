package ParkingLot.Model;

import ParkingLot.Strategy.FeesCalculatorStrategy;
import ParkingLot.Strategy.SpotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private ParkingLotStatus parkingLotStatus;
    private FeesCalculatorStrategy feesCalculatorStrategy;
    private SpotAssignmentStrategy spotAssignmentStrategy;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public FeesCalculatorStrategy getFeesCalculatorStrategy() {
        return feesCalculatorStrategy;
    }

    public void setFeesCalculatorStrategy(FeesCalculatorStrategy feesCalculatorStrategy) {
        this.feesCalculatorStrategy = feesCalculatorStrategy;
    }

    public SpotAssignmentStrategy getSpotAssignmentStrategy() {
        return spotAssignmentStrategy;
    }

    public void setSpotAssignmentStrategy(SpotAssignmentStrategy spotAssignmentStrategy) {
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }
}
