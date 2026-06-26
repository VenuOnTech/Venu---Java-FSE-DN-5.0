import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Book Class
class Book {

    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book ID : " + bookId +
                "\nTitle   : " + title +
                "\nAuthor  : " + author;
    }
}

public class LibraryManagementSystem {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Binary Search
    public static Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int compare = books[mid].getTitle().compareToIgnoreCase(title);

            if (compare == 0) {
                return books[mid];
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    // Display Books
    public static void displayBooks(Book[] books) {

        System.out.println("\n========== Library Books ==========");

        for (Book book : books) {
            System.out.println(book);
            System.out.println("-----------------------------------");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = sc.nextInt();
        sc.nextLine();

        Book[] books = new Book[n];

        System.out.println("\nEnter Book Details");

        for (int i = 0; i < n; i++) {

            System.out.println("\nBook " + (i + 1));

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author Name: ");
            String author = sc.nextLine();

            books[i] = new Book(id, title, author);
        }

        displayBooks(books);

        // Linear Search
        System.out.print("\nEnter Book Title to search using Linear Search: ");
        String searchTitle = sc.nextLine();

        Book result = linearSearch(books, searchTitle);

        System.out.println("\n========== Linear Search Result ==========");

        if (result != null) {
            System.out.println("Book Found!");
            System.out.println(result);
        } else {
            System.out.println("Book not found.");
        }

        // Sort for Binary Search
        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        System.out.print("\nEnter Book Title to search using Binary Search: ");
        searchTitle = sc.nextLine();

        result = binarySearch(books, searchTitle);

        System.out.println("\n========== Binary Search Result ==========");

        if (result != null) {
            System.out.println("Book Found!");
            System.out.println(result);
        } else {
            System.out.println("Book not found.");
        }

        sc.close();
    }
}