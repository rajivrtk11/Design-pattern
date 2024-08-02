package ParkingLot.Model;

import ParkingLot.Strategy.FeesCalculatorStrategy;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private Ticket ticket;
    private Date exitTime;
    private Gate gate;
    private int amount;
    private List<Payment> payments;
    private int billNumber;
    private BillStatus billStatus;
    private FeesCalculatorStrategy feesCalculatorStrategy;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public FeesCalculatorStrategy getFeesCalculatorStrategy() {
        return feesCalculatorStrategy;
    }

    public void setFeesCalculatorStrategy(FeesCalculatorStrategy feesCalculatorStrategy) {
        this.feesCalculatorStrategy = feesCalculatorStrategy;
    }
}
