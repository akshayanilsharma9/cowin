package observers;

import java.util.List;

import model.Center;

public interface Subject
{
        public void addSubscriber(Observer observer);
        public void removeSubscriber(Observer observer);
        public void notifySubscribers(List<Center> centerList);

}