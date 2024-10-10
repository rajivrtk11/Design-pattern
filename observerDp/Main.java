package observerDp;

public class Main {
    public static void main(String[] args) {
        FlipkartOrderPlaced orderPen = new FlipkartOrderPlaced();
        orderPen.addServices(new EmailService());
        orderPen.addServices(new InventoryManagementService());
        orderPen.placeOrder();

        System.out.println("-------------------------------");
        FlipkartOrderPlaced orderAc = new FlipkartOrderPlaced();
        orderAc.addServices(new EmailService());
        orderAc.addServices(new InventoryManagementService());
        orderAc.addServices(new InstallationService());
        orderAc.placeOrder();
    }
}
