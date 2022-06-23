package Project_1;

import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private double price;
    private int pagesRead;
    private int totalPages;

    public Book(String title, String author, String genre, String isbn, double price, int pagesRead, int totalPages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.price = price;
        this.pagesRead = pagesRead;
        this.totalPages = totalPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public double percentOff(double percent) {
        double percentageOff = ( percent / 100 );
        double discountAmount = price * percentageOff;

        return price - discountAmount;
    }

    public void addPagesRead(int numOfPages) {
        if ( numOfPages > 0 && (pagesRead + numOfPages <= totalPages) ) {
            pagesRead += numOfPages;
        } else {
            System.out.println("Enter a positive number...");
        }
    }

    public void printInfo() {
        ArrayList<Object> bookInfo = new ArrayList<>() {
            {
                add(String.format("1. Title: %s",title));
                add(String.format("2. Author: %s", author));
                add(String.format("3. Genre: %s", genre));
                add(String.format("4. ISBN: %s", isbn));
                add(String.format("5. Price: %f", price));
                add(String.format("6. Pages Read: %o", pagesRead));
                add(String.format("7. Total Pages: %o", totalPages));
            }
        };
        for (Object info : bookInfo) {
            System.out.println(info);
        }
    }

    public String toString() {
        return title;
    }
}
