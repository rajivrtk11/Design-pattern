package designPatterns.observerDp;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Observer Interface
    public interface Observer {
        void update(String message);
    }

    // Subject Interface
    public interface Subject {
        void addObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();
    }

    // ConcreteSubject class
    public static class NewsAgency implements Subject {
        private List<Observer> observers = new ArrayList<>();
        private String news;

        // Adds an observer
        @Override
        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        // Removes an observer
        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        // Notifies all observers when state changes
        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(news);
            }
        }

        // Method to update the news and notify observers
        public void setNews(String news) {
            this.news = news;
            notifyObservers();
        }
    }

    // ConcreteObserver class
    public static class NewsChannel implements Observer {
        private String news;

        @Override
        public void update(String news) {
            this.news = news;
            displayNews();
        }

        public void displayNews() {
            System.out.println("Breaking News: " + news);
        }
    }


    public static void main(String[] args) {
        // Create a ConcreteSubject
        NewsAgency newsAgency = new NewsAgency();

        // Create observers
        NewsChannel channel1 = new NewsChannel();
        NewsChannel channel2 = new NewsChannel();

        // Register observers with the subject
        newsAgency.addObserver(channel1);
        newsAgency.addObserver(channel2);

        // Change the state of the subject
        newsAgency.setNews("Java 17 is Released!");

        // Change the state of the subject again
        newsAgency.setNews("New Observer Design Pattern Example!");
    }
}
