import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {

    // Observer Interface
    interface Observer {
        void update(String stockPrice);
    }

    // Subject Interface
    interface Stock {
        void registerObserver(Observer observer);
        void deregisterObserver(Observer observer);
        void notifyObservers();
    }

    // Concrete Subject
    static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private String stockPrice;

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void deregisterObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockPrice);
            }
        }

        public void setStockPrice(String stockPrice) {
            this.stockPrice = stockPrice;
            notifyObservers();
        }
    }

    // Concrete Observer - Mobile App
    static class MobileApp implements Observer {
        private String appName;

        public MobileApp(String appName) {
            this.appName = appName;
        }

        @Override
        public void update(String stockPrice) {
            System.out.println(appName +
                    " received stock update: " + stockPrice);
        }
    }

    // Concrete Observer - Web App
    static class WebApp implements Observer {
        private String websiteName;

        public WebApp(String websiteName) {
            this.websiteName = websiteName;
        }

        @Override
        public void update(String stockPrice) {
            System.out.println(websiteName +
                    " received stock update: " + stockPrice);
        }
    }

    // Test Class
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("Stock Tracker Mobile");
        Observer webApp = new WebApp("Stock Tracker Web");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("Updating Stock Price to Rs.1500");
        stockMarket.setStockPrice("Rs.1500");

        System.out.println("\nUpdating Stock Price to Rs.1700");
        stockMarket.setStockPrice("Rs.1700");

        System.out.println("\nRemoving Web App Observer");
        stockMarket.deregisterObserver(webApp);

        System.out.println("\nUpdating Stock Price to Rs.2000");
        stockMarket.setStockPrice("Rs.2000");
    }
}