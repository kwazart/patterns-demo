package observer.notifications;

class MobileAppNotification implements NotificationListener {
    private final String userId;

    public MobileAppNotification(String userId) {
        this.userId = userId;
    }

    public void onNotification(String event) {
        System.out.println("Sending push to user " + userId + ": " + event);
    }
}
