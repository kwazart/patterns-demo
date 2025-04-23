package observer.notifications;

class SMSNotification implements NotificationListener {
    private final String phone;

    public SMSNotification(String phone) {
        this.phone = phone;
    }

    public void onNotification(String event) {
        System.out.println("Sending SMS to " + phone + ": " + event);
    }
}
