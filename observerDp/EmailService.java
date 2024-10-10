package observerDp;

public class EmailService implements OrderPlacedSubscriber{
    @Override
    public void execute() {
        System.out.println("Email service is executing.");
    }
}
