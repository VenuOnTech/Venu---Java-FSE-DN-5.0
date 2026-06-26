import java.util.Arrays;
import java.util.Comparator;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + productName +
                ", Category: " + category;
    }
}

public class EcommercePlatformSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int productId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].getProductId() == productId) {
                return products[mid];
            } else if (products[mid].getProductId() < productId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(103, "Keyboard", "Accessories"),
                new Product(101, "Laptop", "Electronics"),
                new Product(105, "Monitor", "Electronics"),
                new Product(102, "Mouse", "Accessories"),
                new Product(104, "Printer", "Office")
        };

        // Linear Search
        System.out.println("Linear Search:");
        Product result = linearSearch(products, 102);

        if (result != null)
            System.out.println(result);
        else
            System.out.println("Product not found.");

        // Sort array for Binary Search
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        // Binary Search
        System.out.println("\nBinary Search:");
        result = binarySearch(products, 102);

        if (result != null)
            System.out.println(result);
        else
            System.out.println("Product not found.");
    }
}