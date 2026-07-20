import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Inventory ManagemenClass
public class InventoryManagement {

    public static class Product {

        private final int productId;
        private String productName;
        private int quantity;
        private double price;

        // Constructor
        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        // Getters
        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        // Setters
        public void setProductName(String productName) {
            this.productName = productName;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    private final Map<Integer, Product> inventory;

    // Constructor
    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    // Add Product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product added successfully!");
    }

    // Update Product
    public void updateProduct(int productId, String productName, int quantity, double price) {

        if (inventory.containsKey(productId)) {

            Product product = inventory.get(productId);

            product.setProductName(productName);
            product.setQuantity(quantity);
            product.setPrice(price);

            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    // Delete Product
    public void deleteProduct(int productId) {

        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    // Display Inventory
    public void displayInventory() {

        if (inventory.isEmpty()) {
            System.out.println("\nInventory is empty.");
            return;
        }

        System.out.println("\n================ CURRENT INVENTORY ================");
        System.out.printf("%-10s %-20s %-10s %-10s%n",
                "ID", "Product Name", "Quantity", "Price");

        for (Product product : inventory.values()) {
            System.out.printf("%-10d %-20s %-10d %-10.2f%n",
                    product.getProductId(),
                    product.getProductName(),
                    product.getQuantity(),
                    product.getPrice());
        }

        System.out.println("===================================================\n");
    }

    // Main Method
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            InventoryManagement inventory = new InventoryManagement();

            int choice;

            do {
                System.out.println("\n========= INVENTORY MANAGEMENT SYSTEM =========");
                System.out.println("1. Add Product");
                System.out.println("2. Update Product");
                System.out.println("3. Delete Product");
                System.out.println("4. Display Inventory");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("\n----- Add New Product -----");

                        System.out.print("Enter Product ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Quantity: ");
                        int quantity = sc.nextInt();

                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();

                        inventory.addProduct(new Product(id, name, quantity, price));
                    }
                    case 2 -> {
                        System.out.println("\n----- Update Product -----");

                        System.out.print("Enter Product ID to Update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Product Name: ");
                        String updateName = sc.nextLine();

                        System.out.print("Enter New Quantity: ");
                        int updateQuantity = sc.nextInt();

                        System.out.print("Enter New Price: ");
                        double updatePrice = sc.nextDouble();

                        inventory.updateProduct(updateId, updateName, updateQuantity, updatePrice);
                    }
                    case 3 -> {
                        System.out.println("\n----- Delete Product -----");

                        System.out.print("Enter Product ID to Delete: ");
                        int deleteId = sc.nextInt();

                        inventory.deleteProduct(deleteId);
                    }
                    case 4 -> inventory.displayInventory();
                    case 5 -> System.out.println("\nThank you for using Inventory Management System.");
                    default -> System.out.println("\nInvalid choice! Please enter a number between 1 and 5.");
                }

            } while (choice != 5);
        }
    }
}