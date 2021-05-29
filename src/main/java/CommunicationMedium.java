import java.util.ArrayList;
import java.util.List;

public class CommunicationMedium implements Subject {
    private List<Observer> customers = new ArrayList<>();

    @Override
    public void addSubscriber(Observer customer) {
        customers.add(customer);
    }
    @Override
    public void removeSubscriber(Observer customer) {
        customers.remove(customer);
    }
    @Override
    public void notifySubscribers() {
        System.out.println("New Slots are Available ");
        for(Observer customer: customers) {
            customer.update("Book Slots!");
        }
    }
}