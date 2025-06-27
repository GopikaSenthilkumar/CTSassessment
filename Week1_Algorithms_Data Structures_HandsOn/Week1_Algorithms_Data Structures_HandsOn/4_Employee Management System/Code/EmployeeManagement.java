import java.util.Scanner;
public class EmployeeManagement {
    static Employee[] employees = new Employee[100];  
    static int count = 0;
    public static void addEmployee(int id, String name, String position, double salary) {
        employees[count] = new Employee(id, name, position, salary);
        count++;
    }
    public static int searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return i;
            }
        }
        return -1;
    }
    public static void deleteEmployee(int id) {
        int index = searchEmployee(id);
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            count--;
            System.out.println("Employee deleted");
        } else {
            System.out.println("Employee not found");
        }
    }
    public static void displayAll() {
        if (count == 0) {
            System.out.println("No employees to display");
        } else {
            for (int i = 0; i < count; i++) {
                employees[i].display();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    addEmployee(id, name, position, salary);
                    break;
                case 2:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    int index = searchEmployee(searchId);
                    if (index != -1) {
                        employees[index].display();
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    deleteEmployee(deleteId);
                    break;
                case 4:
                    displayAll();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
