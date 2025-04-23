package observer.notifications;

// Использование
public class NotificationExample {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        // Создаем подписчиков
        EmailNotification email = new EmailNotification("user@example.com");
        SMSNotification sms = new SMSNotification("+1234567890");
        MobileAppNotification app = new MobileAppNotification("user123");

        // Подписываем
        service.subscribe(email);
        service.subscribe(sms);
        service.subscribe(app);

        // Отправляем уведомление - все получают
        service.notify("Server maintenance scheduled for tonight");

        // Отписываем SMS
        service.unsubscribe(sms);

        // Новое уведомление - SMS не получает
        service.notify("Maintenance postponed to tomorrow");
    }
}
