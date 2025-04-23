package observer.notifications;

// Интерфейс наблюдателя (подписчика)
interface NotificationListener {
    void onNotification(String event);
}
