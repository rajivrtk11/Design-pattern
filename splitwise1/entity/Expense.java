package splitwise1.entity;

public class Expense {
    String userId;
    double amount;

    public Expense(String userId, double amount) {
        this.userId = userId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "userId='" + userId + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
