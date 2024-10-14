package ParkingLot.Model;

public class Gate extends BaseModel{
    private GateType gateType;
    private int gateNumber;
    private GateStatus gateStatus;

    @Override
    public String toString() {
        return "Gate{" +
                "gateType=" + (gateType != null ? gateType.toString() : "null") +
                ", gateNumber=" + gateNumber +
                ", gateStatus=" + (gateStatus != null ? gateStatus.toString() : "null") +
                '}';
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
