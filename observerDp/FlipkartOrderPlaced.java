package observerDp;

import java.util.ArrayList;
import java.util.List;

public class FlipkartOrderPlaced {
    private List<OrderPlacedSubscriber> orderPlacedSubscriberList;

    public FlipkartOrderPlaced() {
        /*
        * 1. Always keep in mind to initialize the class attributes.
        * */
        orderPlacedSubscriberList = new ArrayList<>();
    }

    public void addServices(OrderPlacedSubscriber service) {
        orderPlacedSubscriberList.add(service);
    }

    public void removeService(OrderPlacedSubscriber service) {
        orderPlacedSubscriberList.removeLast();
    }

    public void placeOrder() {
        for(OrderPlacedSubscriber subscriber: orderPlacedSubscriberList) {
            subscriber.execute();
        }
    }
}
