package observers;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import model.Center;

@Slf4j
public class Email implements Observer {
    @Override
    public void update(List<Center> availableCenterList) {
        processMessage(availableCenterList);
    }
    private void processMessage(List<Center> availableCenterList) {
        log.info("Send observers.Email to inform Subscriber!");
    }
}