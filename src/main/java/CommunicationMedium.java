import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import model.Center;
import observers.Observer;
import observers.Subject;

@Slf4j
public class CommunicationMedium implements Subject {
    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void addSubscriber(Observer customer) {
        subscribers.add(customer);
    }
    @Override
    public void removeSubscriber(Observer customer) {
        subscribers.remove(customer);
    }
    @Override
    public void notifySubscribers(List<Center> availableCenterList) {
        log.info("New Slots are Available ");
        for(Observer customer: subscribers) {
            customer.update(availableCenterList);
        }
    }
}