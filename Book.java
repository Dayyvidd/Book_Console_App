/* Author: David Perez
   Version: 1
   Java: 16.0.2

   The Book class contains all instance variables and methods for a book.
   The purpose of this class is to model the characteristics of a book so that a user may create, update, and add
   their own books.
*/
public class Book {
    // Instance variable declarations (Characteristics/Attributes).
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private double price;
    private int pagesRead;

    // Constructor.
    public Book(String title, String author, String genre, String isbn, double price, int pagesRead) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.price = price;
        this.pagesRead = pagesRead;
    }

    // get methods.
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    // set methods.
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    // Calculation methods.
    public void addPagesRead(int additionalPages) {
        pagesRead += additionalPages;
    }

    public void discountPrice(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            double discountAmount = (percentage / 100) * price;
            price -= discountAmount;
        }
    }

    // Prints all attribute values of a given book in a numbered menu format.
    public void printAttributes() {
        System.out.println(String.format("1. Title: %s", title));
        System.out.println(String.format("2. Author: %s", author));
        System.out.println(String.format("3. Genre: %s", genre));
        System.out.println(String.format("4. ISBN: %s", isbn));
        System.out.println(String.format("5. Price: %s", price));
        System.out.println(String.format("6. Pages Read: %s", pagesRead));
    }

    // Over-ridden toString method to print object titles.
    public String toString() {
        return this.title;
    }
}
