public class StockObserverTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer mobile1 = new MobileApp("GopikaMobile");
        Observer web1 = new WebApp("GopikaWeb");
        market.registerObserver(mobile1);
        market.registerObserver(web1);
        market.setStockPrice(1025.75);
        market.removeObserver(web1);
        market.setStockPrice(1080.50);
    }
}
