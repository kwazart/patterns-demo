package observer.news;

// Конкретные наблюдатели
class NewsChannel implements Observer {
    private final String name;
    private String lastNews;

    public NewsChannel(String name) {
        this.name = name;
    }

    public void update(String news) {
        this.lastNews = news;
        display();
    }

    public void display() {
        System.out.println(name + " received news: " + lastNews);
    }
}