import java.util.Scanner;
/*Identify commonalities and differences between Publication, Book and Magazine classes. Title,
 Price, Copies are common instance variables and saleCopy is common method. The differences
  are, Bookclass has author and orderCopies(). Magazine Class has methods orderQty, Current issue,
 receiveissue().Write a program to find how many copies of the given books are ordered and display total sale
  of publication. */
class Publication {

    String title;
    double price;
    int copies;

    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    public void saleCopy() {
        if (copies > 0) {
            copies--;
            System.out.println("One copy of " + title + " sold.");
        } else {
            System.out.println("No copies of " + title + " available.");
        }
    }

    public void orderCopies(int quantity) {
        copies += quantity;
        System.out.println(quantity + " copies of " + title + " ordered.");
    }

    public int getCopies() {
        return copies;
    }

    public double getPrice() {
        return price;
    }
}

class Book extends Publication {
    String author;

    public Book(String title, double price, int copies, String author) {
        super(title, price, copies);
        this.author = author;
    }
}

class Magazine extends Publication {
    int currentIssue;

    public Magazine(String title, double price, int copies, int currentIssue) {
        super(title, price, copies);
        this.currentIssue = currentIssue;
    }

    public void receiveIssue(int issue) {
        currentIssue = issue;
        System.out.println("Received issue " + issue + " of " + title + ".");
    }
}

public class PR2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Book
        System.out.println("Enter Book details:");
        System.out.print("Title: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Price: ");
        double bookPrice = scanner.nextDouble();
        System.out.print("Copies: ");
        int bookCopies = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Author: ");
        String bookAuthor = scanner.nextLine();
        Book book = new Book(bookTitle, bookPrice, bookCopies, bookAuthor);

        // Create Magazine
        System.out.println("Enter Magazine details:");
        System.out.print("Title: ");
        String magazineTitle = scanner.nextLine();
        System.out.print("Price: ");
        double magazinePrice = scanner.nextDouble();
        System.out.print("Copies: ");
        int magazineCopies = scanner.nextInt();
        System.out.print("Current Issue: ");
        int magazineIssue = scanner.nextInt();
        Magazine magazine = new Magazine(magazineTitle, magazinePrice, magazineCopies, magazineIssue);

        // Operations on Book
        System.out.println("Enter number of copies to sell from Book: ");
        int bookSellCount = scanner.nextInt();
        for (int i = 0; i < bookSellCount; i++) {
            book.saleCopy();
        }

        System.out.println("Enter number of copies to order for Book: ");
        int bookOrderCount = scanner.nextInt();
        book.orderCopies(bookOrderCount);

        // Operations on Magazine
        System.out.println("Enter number of copies to sell from Magazine: ");
        int magazineSellCount = scanner.nextInt();
        for (int i = 0; i < magazineSellCount; i++) {
            magazine.saleCopy();
        }

        System.out.println("Enter number of copies to order for Magazine: ");
        int magazineOrderCount = scanner.nextInt();
        magazine.orderCopies(magazineOrderCount);

        // Calculate and display total value
        double totalValue = (book.getPrice() * book.getCopies()) + (magazine.getPrice() * magazine.getCopies());
        System.out.println("Total sale of publication: $" + totalValue);
        scanner.close();
    }
}