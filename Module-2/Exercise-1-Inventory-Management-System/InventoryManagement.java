import java.util.HashMap;
import java.util.Map;

// Product Class
class Product {

    private int productId;
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

// Inventory Management Class
public class InventoryManagement {

    private Map<Integer, Product> inventory;

    // Constructor
    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    // Add Product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product added successfully.");
    }

    // Update Product
    public void updateProduct(int productId, String productName,
                              int quantity, double price) {

        if (inventory.containsKey(productId)) {

            Product product = inventory.get(productId);

            product.setProductName(productName);
            product.setQuantity(quantity);
            product.setPrice(price);

            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete Product
    public void deleteProduct(int productId) {

        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display Inventory
    public void displayInventory() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\n---------------- Inventory ----------------");
        System.out.println("ID\tName\t\tQuantity\tPrice");

        for (Product product : inventory.values()) {

            System.out.println(
                    product.getProductId() + "\t"
                            + product.getProductName() + "\t\t"
                            + product.getQuantity() + "\t\t"
                            + product.getPrice());
        }

        System.out.println("-------------------------------------------");
    }

    // Main Method (Testing)
    public static void main(String[] args) {

        InventoryManagement inventory = new InventoryManagement();

        // Add Products
        inventory.addProduct(new Product(101, "Laptop", 10, 65000));
        inventory.addProduct(new Product(102, "Mouse", 50, 600));
        inventory.addProduct(new Product(103, "Keyboard", 30, 1200));

        // Display Inventory
        inventory.displayInventory();

        // Update Product
        inventory.updateProduct(102, "Wireless Mouse", 45, 750);

        // Display Inventory
        inventory.displayInventory();

        // Delete Product
        inventory.deleteProduct(103);

        // Display Inventory
        inventory.displayInventory();
    }
}