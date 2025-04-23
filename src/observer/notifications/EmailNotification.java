package observer.notifications;

// Подписчики
class EmailNotification implements NotificationListener {
    private final String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    public void onNotification(String event) {
        System.out.println("Sending email to " + email + ": " + event);
    }
}
