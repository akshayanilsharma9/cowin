package observers;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import model.Center;

@Slf4j
public class WhatsApp implements Observer {
    @Override
    public void update(List<Center> availableCenterList) {
        log.info("Send observers.WhatsApp message to inform Subscriber!");
    }
}