import java.util.Scanner;

class Employee {

    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "Employee ID : " + employeeId +
                "\nName        : " + name +
                "\nPosition    : " + position +
                "\nSalary      : " + salary;
    }
}

public class EmployeeManagementSystem {

    static Employee[] employees;
    static int count = 0;

    // Add Employee
    public static void addEmployee(Employee employee) {

        if (count == employees.length) {
            System.out.println("Employee array is full. Cannot add more employees.");
            return;
        }

        employees[count] = employee;
        count++;

        System.out.println("Employee added successfully.");
    }

    // Search Employee
    public static void searchEmployee(int employeeId) {

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == employeeId) {

                System.out.println("\nEmployee Found");
                System.out.println("---------------------------");
                System.out.println(employees[i]);
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // Traverse Employees
    public static void traverseEmployees() {

        if (count == 0) {
            System.out.println("No employee records available.");
            return;
        }

        System.out.println("\n========= Employee Records =========");

        for (int i = 0; i < count; i++) {

            System.out.println(employees[i]);
            System.out.println("--------------------------------");
        }
    }

    // Delete Employee
    public static void deleteEmployee(int employeeId) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee deleted successfully.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum number of employees: ");
        int size = sc.nextInt();
        sc.nextLine();

        employees = new Employee[size];

        int choice;

        do {

            System.out.println("\n========== Employee Management System ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\nEnter Employee Details");

                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Employee Position: ");
                    String position = sc.nextLine();

                    System.out.print("Employee Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    addEmployee(new Employee(id, name, position, salary));
                    break;

                case 2:

                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();

                    searchEmployee(searchId);
                    break;

                case 3:

                    traverseEmployees();
                    break;

                case 4:

                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();

                    deleteEmployee(deleteId);
                    break;

                case 5:

                    System.out.println("Exiting Employee Management System...");
                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}