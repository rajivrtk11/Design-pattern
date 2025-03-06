package TicTacToe.generic;

public class WalletPayment<T> extends Payment<T>{
    int count;

    public WalletPayment() {
        count = 0;
    }

    @Override
    void validateBeneficiary(T beneficiary) {
        System.out.println("Wallet beneficiary validated"+ beneficiary);
    }

    @Override
    void doTransaciton() {
        System.out.println("Wallet transaction completed !!");
    }

    @Override
    boolean statusCheck() {
        System.out.println("Wallet status check!!");
        count++;
        if(count%2 == 0) return true;
        return false;
    }
}
