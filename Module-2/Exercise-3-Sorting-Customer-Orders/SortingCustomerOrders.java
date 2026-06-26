import java.util.Scanner;

class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                ", Customer Name: " + customerName +
                ", Total Price: " + totalPrice;
    }
}

public class SortingCustomerOrders {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
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

    // Display Orders
    public static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of orders: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        Order[] orders1 = new Order[n];
        Order[] orders2 = new Order[n];

        System.out.println("\nEnter Order Details:");

        for (int i = 0; i < n; i++) {

            System.out.println("\nOrder " + (i + 1));

            System.out.print("Enter Order ID: ");
            int orderId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            String customerName = sc.nextLine();

            System.out.print("Enter Total Price: ");
            double totalPrice = sc.nextDouble();

            orders1[i] = new Order(orderId, customerName, totalPrice);
            orders2[i] = new Order(orderId, customerName, totalPrice);
        }

        System.out.println("\nOrders Before Bubble Sort:");
        displayOrders(orders1);

        bubbleSort(orders1);

        System.out.println("\nOrders After Bubble Sort (Ascending by Total Price):");
        displayOrders(orders1);

        System.out.println("\nOrders Before Quick Sort:");
        displayOrders(orders2);

        quickSort(orders2, 0, orders2.length - 1);

        System.out.println("\nOrders After Quick Sort (Ascending by Total Price):");
        displayOrders(orders2);

        sc.close();
    }
}