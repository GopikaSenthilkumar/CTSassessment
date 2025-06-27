import java.util.Scanner;
import java.util.Arrays;
class Book implements Comparable<Book> {
    int bookId;
    String title;
    String author;
    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }
    void display() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }
}
public class LibraryManagement {
    static Book[] books = new Book[100];
    static int count = 0;
    public static void addBook(int id, String title, String author) {
        books[count++] = new Book(id, title, author);
    }
    public static void linearSearch(String title) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                books[i].display();
                found = true;
            }
        }
        if (!found) System.out.println("Book not found.");
    }
    public static void binarySearch(String title) {
        Arrays.sort(books, 0, count);
        int low = 0, high = count - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) {
                books[mid].display();
                return;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        addBook(1, "Java Programming", "James Gosling");
        addBook(2, "Data Structures", "Narasimha Karumanchi");
        addBook(3, "C Programming", "Dennis Ritchie");
        addBook(4, "Python Basics", "Guido van Rossum");

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Search Book (Linear Search)");
            System.out.println("2. Search Book (Binary Search)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter book title to search: ");
                    String title1 = sc.nextLine();
                    linearSearch(title1);
                    break;
                case 2:
                    System.out.print("Enter book title to search: ");
                    String title2 = sc.nextLine();
                    binarySearch(title2);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
        sc.close();
    }
}
