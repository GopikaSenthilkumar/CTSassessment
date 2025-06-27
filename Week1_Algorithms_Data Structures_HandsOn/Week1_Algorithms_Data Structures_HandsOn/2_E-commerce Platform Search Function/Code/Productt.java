class Productt {
    int productId;
    String productName;
    String category;

    Productt(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    void display() {
        System.out.println("ID: " + productId + ", Name: " + productName + ", Category: " + category);
    }
}
