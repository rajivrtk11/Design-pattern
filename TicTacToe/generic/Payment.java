package TicTacToe.generic;

public abstract class Payment<T> {
    abstract void validateBeneficiary(T beneficiary);
    abstract void doTransaciton();
    abstract boolean statusCheck();
}
