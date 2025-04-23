package observer.notifications;

import java.util.ArrayList;
import java.util.List;

// Издатель (система уведомлений)
class NotificationService {
    private final List<NotificationListener> listeners = new ArrayList<>();

    public void subscribe(NotificationListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(NotificationListener listener) {
        listeners.remove(listener);
    }

    public void notify(String event) {
        for (NotificationListener listener : listeners) {
            listener.onNotification(event);
        }
    }
}