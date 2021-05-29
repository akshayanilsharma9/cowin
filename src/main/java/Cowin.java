import java.io.IOException;
import java.util.Timer;

public class Cowin {

public static void main(String args[]) throws IOException, InterruptedException {
    Timer time = new Timer(); // Instantiate Timer Object
    CheckCowin checkCowin = new CheckCowin();
    checkCowin.checkSlots();// Instantiate SheduledTask class
    time.schedule(checkCowin, 0, 5000); // Create Repetitively task for every 1 secs

    Subject infromCitizens = new CommunicationMedium();
    Observer whatsAppUser = new WhatsApp();
    Observer emailUser = new Email();

    // Adding two subscribers to the notifications
    infromCitizens.addSubscriber(whatsAppUser);
    infromCitizens.addSubscriber(emailUser);

    // Notifying customers (observers)
    infromCitizens.notifySubscribers();
}
}
