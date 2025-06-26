public class SortOrders {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }
    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
    public static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            o.display();
        }
    }
    public static void main(String[] args) {
        Order[] orders = new Order[5];
        orders[0] = new Order(201, "Gopika", 320.0);
        orders[1] = new Order(202, "Ragav", 150.5);
        orders[2] = new Order(203, "Geetha", 450.2);
        orders[3] = new Order(204, "Praveen", 120.0);
        orders[4] = new Order(205, "Radha", 200.3);
        System.out.println("Original Order List:");
        displayOrders(orders);
        bubbleSort(orders);
        System.out.println("\nAfter Bubble Sort by Total Price:");
        displayOrders(orders);
        orders[0] = new Order(201, "Gopika", 320.0);
        orders[1] = new Order(202, "Ragav", 150.5);
        orders[2] = new Order(203, "Geetha", 450.2);
        orders[3] = new Order(204, "Praveen", 120.0);
        orders[4] = new Order(205, "Radha", 200.3);
        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nAfter Quick Sort by Total Price:");
        displayOrders(orders);
    }
}
