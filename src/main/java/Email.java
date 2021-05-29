public class Email implements Observer {
    @Override
    public void update(String message) {
        processMessage(message);
    }
    private void processMessage(String message) {
        System.out.println("Send Email to inform Subscriber!");
    }
}