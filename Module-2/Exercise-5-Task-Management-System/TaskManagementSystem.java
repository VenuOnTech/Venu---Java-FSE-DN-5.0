import java.util.Scanner;

// Task Class
class Task {

    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Task ID    : " + taskId +
               "\nTask Name  : " + taskName +
               "\nStatus     : " + status;
    }
}

// Singly Linked List
class TaskLinkedList {

    private Task head;

    // Add Task
    public void addTask(int taskId, String taskName, String status) {

        Task newTask = new Task(taskId, taskName, status);

        if (head == null) {
            head = newTask;
        } else {

            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }

        System.out.println("Task added successfully.");
    }

    // Search Task
    public void searchTask(int taskId) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == taskId) {

                System.out.println("\nTask Found");
                System.out.println("----------------------");
                System.out.println(temp);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task not found.");
    }

    // Display Tasks
    public void traverseTasks() {

        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n========== Task List ==========");

        Task temp = head;

        while (temp != null) {

            System.out.println(temp);
            System.out.println("---------------------------");

            temp = temp.next;
        }
    }

    // Delete Task
    public void deleteTask(int taskId) {

        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != taskId) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task deleted successfully.");
        }
    }
}

// Main Class
public class TaskManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TaskLinkedList taskList = new TaskLinkedList();

        int choice;

        do {

            System.out.println("\n========== Task Management System ==========");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Display All Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\nEnter Task Details");

                    System.out.print("Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Task Name: ");
                    String name = sc.nextLine();

                    System.out.print("Task Status (Pending/Completed): ");
                    String status = sc.nextLine();

                    taskList.addTask(id, name, status);
                    break;

                case 2:

                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();

                    taskList.searchTask(searchId);
                    break;

                case 3:

                    taskList.traverseTasks();
                    break;

                case 4:

                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = sc.nextInt();

                    taskList.deleteTask(deleteId);
                    break;

                case 5:

                    System.out.println("Exiting Task Management System...");
                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}