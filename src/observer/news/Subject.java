package observer.news;

// Интерфейс субъекта (издателя)
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}