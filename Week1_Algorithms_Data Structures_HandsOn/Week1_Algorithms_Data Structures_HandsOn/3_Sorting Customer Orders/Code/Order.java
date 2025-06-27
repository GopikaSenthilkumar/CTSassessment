public class Order {
    int orderId;
    String customerName;
    double totalPrice;
    public Order(int id, String name, double price) {
        this.orderId = id;
        this.customerName = name;
        this.totalPrice = price;
    }
    public void display() {
        System.out.println("Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: " + totalPrice);
    }
}
