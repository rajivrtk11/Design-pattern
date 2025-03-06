package TicTacToe.generic;

public class Main {
    public static void main(String[] args) {
        Notes<?, ?> notes = new Notes<>();
//        notes.content = "hello";
//        System.out.println("notes "+ notes);

//        Student st = new Student();
//        st.name = "Rajiv";
//        st.age = "12";
//        st.id = "12";
//        st.mobile = "121212";
//
//        Notes<String, Student> notes1 = new Notes<>();
//        notes1.content = st;
//        System.out.println(notes1);

        Payment<String> bankPayment = new BankPayment<>();
        bankPayment.statusCheck();
        bankPayment.validateBeneficiary("Rajiv singh");

        Payment<Integer> bankPaymentUsingInteger = new BankPayment<>();
        bankPaymentUsingInteger.validateBeneficiary(12121212);


    }

}
