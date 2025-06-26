import java.util.HashMap;
import java.util.Scanner;

public class InventorySystem {
    HashMap<String, Product> inventory = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    void addProduct() {
        System.out.print("Enter Product ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        Product p = new Product(id, name, qty, price);
        inventory.put(id, p);
        System.out.println("Product added successfully.\n");
    }

    void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        String id = sc.nextLine();
        if (inventory.containsKey(id)) {
            System.out.print("Enter New Name: ");
            String name = sc.nextLine();
            System.out.print("Enter New Quantity: ");
            int qty = sc.nextInt();
            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            Product p = inventory.get(id);
            p.productName = name;
            // p.quantity = qty;
            p.price = price;
            System.out.println("Product updated.\n");
        } else {
            System.out.println("Product not found.\n");
        }
    }

    void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        String id = sc.nextLine();
        if (inventory.remove(id) != null) {
            System.out.println("Product deleted.\n");
        } else {
            System.out.println("Product not found.\n");
        }
    }

    void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.\n");
        } else {
            for (Product p : inventory.values()) {
                p.display();
            }
        }
    }

    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- Inventory Menu -----");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show All Products");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    system.addProduct();
                    break;
                case 2:
                    system.updateProduct();
                    break;
                case 3:
                    system.deleteProduct();
                    break;
                case 4:
                    system.showInventory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.\n");
            }
        } while (choice != 5);
    }
}
