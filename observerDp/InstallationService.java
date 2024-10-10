package observerDp;

public class InstallationService implements OrderPlacedSubscriber{
    @Override
    public void execute() {
        System.out.println("Installation service.");
    }
}
