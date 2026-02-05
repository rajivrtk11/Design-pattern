package movieticketbookingsystem.entities;

import movieticketbookingsystem.enums.PaymentStatus;

public class Payment {
    String id;
    PaymentStatus paymentStatus;
    String txnId;

    public Payment(String id, PaymentStatus paymentStatus, String txnId) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.txnId = txnId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", txnId='" + txnId + '\'' +
                '}';
    }
}

