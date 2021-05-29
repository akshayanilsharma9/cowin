import java.io.IOException;
import java.util.List;
import java.util.Timer;

import lombok.extern.slf4j.Slf4j;
import model.Center;
import observers.Email;
import observers.Observer;
import observers.Subject;
import observers.WhatsApp;

@Slf4j
public class Cowin {

    public static void main(String args[]) throws IOException {
        Timer time = new Timer(); // Instantiate Timer Object
        GetVaccinationDetail getVaccinationDetail = new GetVaccinationDetail();
        List<Center> centerList = getVaccinationDetail.getVaccinationSlots();
        time.schedule(getVaccinationDetail, 0, 5000);
        Subject infromSubscribers = new CommunicationMedium();
        Observer whatsAppUser = new WhatsApp();
        Observer emailUser = new Email();

        // Adding two subscribers to the notifications
        infromSubscribers.addSubscriber(whatsAppUser);
        infromSubscribers.addSubscriber(emailUser);

        // Notifying subscribers (observers)
        infromSubscribers.notifySubscribers(centerList);
        log.info("Notifications Sent to Subscribers");
    }
}
