public class WhatsApp implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Send WhatsApp message to inform Subscriber!");
    }
}