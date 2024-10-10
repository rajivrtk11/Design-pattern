package observerDp;

public class InventoryManagementService implements OrderPlacedSubscriber{
    @Override
    public void execute() {
        System.out.println("Inventory management service.");
    }
}
