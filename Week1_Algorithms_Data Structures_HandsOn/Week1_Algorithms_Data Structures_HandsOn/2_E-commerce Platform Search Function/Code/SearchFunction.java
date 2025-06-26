import java.util.*;
public class SearchFunction {
    public static int linearSearch(Productt[] products, String searchName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(searchName)) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(Productt[] products, String searchName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = products[mid].productName.compareToIgnoreCase(searchName);
            if (compare == 0) return mid;
            else if (compare < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static void sortProducts(Productt[] products) {
        Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));
    }
    public static void main(String[] args) {
        Productt[] productList = new Productt[5];
        productList[0] = new Productt(101, "Laptop", "Electronics");
        productList[1] = new Productt(102, "Shoes", "Footwear");
        productList[2] = new Productt(103, "Watch", "Accessories");
        productList[3] = new Productt(104, "Mobile", "Electronics");
        productList[4] = new Productt(105, "Book", "Stationery");
        System.out.println("Unsorted Product List:");
        for (Productt p : productList) {
            p.display();
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter product name: ");
        String searchInput = sc.nextLine();
        int linResult = linearSearch(productList, searchInput);
        System.out.println("\nLinear Search Result:");
        if (linResult != -1) {
            productList[linResult].display();
        } else {
            System.out.println("Product not found.");
        }
        sortProducts(productList);
        System.out.println("\nSorted Product List:");
        for (Productt p : productList) {
            p.display();
        }
        int binResult = binarySearch(productList, searchInput);
        System.out.println("\nBinary Search Result:");
        if (binResult != -1) {
            productList[binResult].display();
        } else {
            System.out.println("Product not found.");
        }
        sc.close();
    }
}