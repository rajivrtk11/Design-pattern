package TicTacToe.generic;

public class BankPayment<T> extends Payment<T>{
    int count;

    public BankPayment() {
        count = 0;
    }

    @Override
    void validateBeneficiary(T beneficiary) {
        System.out.println("Bank Beneficiary validated "+ beneficiary);
    }

    @Override
    void doTransaciton() {
        System.out.println("Bank Transaction completed !!");
    }

    @Override
    boolean statusCheck() {
        System.out.println("Bank status check");
        count++;
        if(count%2 == 0) return true;
        return false;
    }
}
