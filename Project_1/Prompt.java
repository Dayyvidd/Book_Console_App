package Project_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {

    private ArrayList<Book> books = new ArrayList<>() {
        {
            add(new Book("Clean Code", "Robert Cecil Martin",
                    "Programming", "9780132350884", 44.72, 0, 464));
            add(new Book("Cracking the Coding Interview", "Gayle Laakmann McDowell",
                    "Programming", "9780984782802", 25.00, 0, 500));
            add(new Book("The Self‑taught Programmer", "Cory Althoff",
                    "Programming", "9780999685907", 20.00, 0, 301));

            add(new Book("Learning Python: Powerful Object-Oriented Programming", "Mark Lutz",
                    "Programming", "9781548987831", 56.16, 0, 1650));
            add(new Book("Think Like a Programmer: An Introduction to Creative Problem Solving", "V. Anton Spraul",
                    "Programming", "9783826692789", 20.49, 0, 256));
            add(new Book("The Pragmatic Programmer", "Andy Hunt and Dave Thomas",
                    "Programming", "9780201616224", 30.18, 0, 352));
        }
    };
    private final Scanner userInput = new Scanner(System.in);

    public void printPrompt() {
        System.out.println("\nMenu options: ");

        System.out.println("1. View books");
        System.out.println("2. Add a book");
        System.out.println("3. Remove a book");
        System.out.println("4. Update a book");
        System.out.println("5. Exit");

        System.out.println("Please enter the number of the option you would like to perform: ");
    }

    public void viewBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%o. %s%n", i + 1, books.get(i));
        }

        System.out.println("\nWould you like to view more options? Y/N: ");
        //Scanner menu = new Scanner(System.in);
        String input = userInput.next();

        if (input.equalsIgnoreCase("y")) {
            viewBookOptions();
        }
    }

    public void viewBookOptions() {
        System.out.println("Enter the line number of the book you would like to edit (Enter 0 to exit): ");
        //Scanner menu = new Scanner(System.in);
        int input = userInput.nextInt();

        if (input > 0 && input <= books.size()) {
            Book book = books.get(input - 1);
            editBookInfo(book);
        } else if (input == 0) {
            return;
        } else {
            System.out.println("Please enter a valid selection: ");
            viewBooks();
        }
    }

    public void editBookInfo(Book book) {
        //Scanner menu = new Scanner(System.in);
        book.printInfo();
        System.out.printf("Pick the attribute line number you would like to edit for %s (Enter 0 to exit):%n", book.getTitle());

        int input = userInput.nextInt();
        Scanner userInput = new Scanner(System.in);

        switch(input) {
            case 0:
                return;
            case 1:
                System.out.printf("Please enter a new title for %s: ", book.getTitle());
                book.setTitle(userInput.nextLine());
                break;
            case 2:
                System.out.printf("Please enter a new author for %s: ", book.getAuthor());
                book.setAuthor(userInput.nextLine());
                break;
            case 3:
                System.out.printf("Please enter a new genre for %s: ", book.getGenre());
                book.setGenre(userInput.nextLine());
                break;
            case 4:
                System.out.printf("Please enter a new isbn for %s: ", book.getIsbn());
                book.setIsbn(userInput.nextLine());
                break;
            case 5:
                System.out.println("Please enter a new price: ");
                book.setPrice(userInput.nextDouble());
                break;
            case 6:
                System.out.println("Please enter the new pages read: ");
                book.setPagesRead(userInput.nextInt());
                break;
            case 7:
                System.out.println("Please enter the total pages: ");
                book.setTotalPages(userInput.nextInt());
                break;
        }

        books.set(input - 1, book);
        System.out.println("Would you like to make another edit? Y/N ");
        //Scanner subMenu = new Scanner(System.in);

        String editAgain = userInput.nextLine();

        if (editAgain.equalsIgnoreCase("y")) {
            editBookInfo(book);
        }
    }

    public void addBook() {
        //Scanner userInput = new Scanner(System.in);

        System.out.println("Title: ");
        String title = userInput.nextLine();
        System.out.println("Author: ");
        String author = userInput.nextLine();

        System.out.println("Genre: ");
        String genre = userInput.nextLine();
        System.out.println("ISBN: ");
        String isbn = userInput.nextLine();

        System.out.println("Price: ");
        double price = userInput.nextDouble();
        System.out.println("Pages Read: ");
        int pagesRead = userInput.nextInt();

        System.out.println("Total Pages: ");
        int totalPages = userInput.nextInt();

        books.add(new Book(title, author, genre, isbn, price, pagesRead, totalPages));
    }

    public void removeBook() {

    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
