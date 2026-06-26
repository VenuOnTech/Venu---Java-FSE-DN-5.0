import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

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
        return "Product ID      : " + productId +
                "\nProduct Name    : " + productName +
                "\nCategory        : " + category;
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

    // Display Products
    public static void displayProducts(Product[] products) {

        System.out.println("\n--------------- Product List ---------------");

        for (Product product : products) {
            System.out.println(product);
            System.out.println("--------------------------------------------");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];

        System.out.println("\nEnter Product Details");

        for (int i = 0; i < n; i++) {

            System.out.println("\nProduct " + (i + 1));

            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Product Category: ");
            String category = sc.nextLine();

            products[i] = new Product(id, name, category);
        }

        displayProducts(products);

        System.out.print("\nEnter Product ID to search using Linear Search: ");
        int searchId = sc.nextInt();

        Product result = linearSearch(products, searchId);

        System.out.println("\n========== Linear Search Result ==========");

        if (result != null) {
            System.out.println("Product Found!");
            System.out.println(result);
        } else {
            System.out.println("Product not found.");
        }

        // Sort before Binary Search
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        System.out.print("\nEnter Product ID to search using Binary Search: ");
        searchId = sc.nextInt();

        result = binarySearch(products, searchId);

        System.out.println("\n========== Binary Search Result ==========");

        if (result != null) {
            System.out.println("Product Found!");
            System.out.println(result);
        } else {
            System.out.println("Product not found.");
        }

        sc.close();
    }
}