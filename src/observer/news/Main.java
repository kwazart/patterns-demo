package observer.news;

// Использование
public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        NewsChannel channel1 = new NewsChannel("BBC");
        NewsChannel channel2 = new NewsChannel("CNN");
        NewsChannel channel3 = new NewsChannel("Al Jazeera");

        // Подписываем каналы на новости
        agency.registerObserver(channel1);
        agency.registerObserver(channel2);
        agency.registerObserver(channel3);

        // Публикуем новость - все получают уведомление
        agency.setNews("Breaking news: Java 21 released!");

        // Отписываем один канал
        agency.removeObserver(channel2);

        // Новая новость - получают только оставшиеся подписчики
        agency.setNews("Update: New features in Java 21");
    }
}
