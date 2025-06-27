public interface Stock {
    void registerObserver(Observer obs);

    void removeObserver(Observer obs);

    void notifyObservers();
}
