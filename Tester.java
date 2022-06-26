/* Author: David Perez
   Version: 1
   Java: 16.0.2

   The Tester class contains all instance variables and methods for a book.
   The purpose of this class is to initiate the program with a console menu that a user may interact with.
   The program launches with a predefined list of books that a user can view, update, remove or add to.
*/

// Import statements.
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) throws IOException {
        // ArrayList with pre-defined books.
        ArrayList<Book> books = new ArrayList<>();
            books.add(new Book("Clean Code", "Robert Cecil Martin",
                    "Programming", "9783826696381", 42.49, 0));
            books.add(new Book("Big Java: Early Objects", "Cay S. Horstmann",
                    "Programming", "9781119499442", 49.98, 0));
            books.add(new Book("The Clean Coder", "Robert C. Martin",
                    "Programming", "9781283544221", 37.29, 0));
            books.add(new Book("The Pragmatic Programmer", "Andrew Hunt",
                    "Programming", "9786612502477", 26.99, 0));
            books.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler",
                    "Programming", "9780134757704", 37.49, 0));
            books.add(new Book("Cracking the Coding Interview", "Gayle Laakmann McDowell",
                    "Programming", "9784839942397", 24.49, 0));
        Scanner scan = new Scanner(System.in);
        String exit = "e";

        // Loop to keep program running while exit != "exit".
        while(!exit.equals("exit")) {

            // Printed menu of options.
            System.out.println("Menu Options:");
            System.out.println("1. View Books");
            System.out.println("2. Add a book");
            System.out.println("3. Remove a book");
            System.out.println("4. Update a book");
            System.out.println("5. Discount a book");
            System.out.println("6. Exit");

            System.out.println("\nSelect a menu option: ");

            // Capturing users menu option.
            int menuOption = scan.nextInt();

            // Switch block to distinguish what action to take based on menu option selected.
            switch(menuOption) {

                // View Books
                case 1:
                    // Print menu of numbered books.
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println(String.format("%o. %s", i + 1, books.get(i)));
                    }

                    // Prompt user to view additional details about a specific book or exit.
                    System.out.println("\nTo view book details enter the line number of the book or enter 0 to exit: ");
                    int index = scan.nextInt();

                    // index should not be smaller than 0 or greater than the amount of books in the list.
                    if (index > 0 && index <= books.size()) {
                        Book currentBook = books.get(index - 1);
                        currentBook.printAttributes();

                        System.out.println("\nPress enter to exit.");

                        // Hold current screen until user presses enter key.
                        System.in.read();
                    }

                    break;

                // Add a book
                case 2:
                    // Prompt user for each of the required attributes that make-up a book.
                    System.out.println("Please enter your books title, author, genre, isbn, price and pages read.\n");
                    System.out.println("Title: ");
                    String title = scan.next();

                    System.out.println("Author: ");
                    String author = scan.next();

                    System.out.println("Genre: ");
                    String genre = scan.next();

                    System.out.println("ISBN: ");
                    String isbn = scan.next();

                    System.out.println("Price: ");
                    double price = scan.nextDouble();

                    System.out.println("Pages Read: ");
                    int pagesRead = scan.nextInt();

                    // Add this new book to the existing list of books.
                    books.add(new Book(title, author, genre, isbn, price, pagesRead));

                    break;

                // Remove a book
                case 3:
                    // Print menu of numbered books.
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println(String.format("%o. %s", i + 1, books.get(i)));
                    }

                    // Prompt user to select the line number of the book they would like to remove.
                    System.out.println("\nPlease enter the line number of the book you would like to remove: ");
                    int lineNumber = scan.nextInt();
                    books.remove(lineNumber - 1);

                    break;

                // Update a book
                case 4:
                    // Print menu of numbered books.
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println(String.format("%o. %s", i + 1, books.get(i)));
                    }

                    // Prompt user to select the line number of the book they would like to edit.
                    System.out.println("\nPlease enter the line number of the book you would like to edit: ");
                    int lineNum = scan.nextInt();
                    Book selectedBook = books.get(lineNum - 1);

                    // Print the attributes of the selected books. See Book class for specifics.
                    selectedBook.printAttributes();
                    System.out.println("\nPlease enter the line number of the attribute you would like to edit: ");
                    int line = scan.nextInt();

                    // Switch block to distinguish what action to take based on attribute option selected.
                    switch(line) {
                        case 1:
                            System.out.println(String.format("Enter a new Title for %s: ", selectedBook.getTitle()));
                            String newTitle = scan.next();
                            selectedBook.setTitle(newTitle);
                            break;
                        case 2:
                            System.out.println(String.format("Enter a new Author for %s: ", selectedBook.getTitle()));
                            String newAuthor = scan.next();
                            selectedBook.setAuthor(newAuthor);
                            break;
                        case 3:
                            System.out.println(String.format("Enter a new Genre for %s: ", selectedBook.getTitle()));
                            String newGenre = scan.next();
                            selectedBook.setGenre(newGenre);
                            break;
                        case 4:
                            System.out.println(String.format("Enter a new ISBN for %s: ", selectedBook.getTitle()));
                            String newIsbn = scan.next();
                            selectedBook.setIsbn(newIsbn);
                            break;
                        case 5:
                            System.out.println(String.format("Enter a new Price for %s: ", selectedBook.getTitle()));
                            double newPrice = scan.nextDouble();
                            selectedBook.setPrice(newPrice);
                            break;
                        case 6:
                            System.out.println(String.format(
                                    "Enter how many more Pages read for %s: ", selectedBook.getTitle()));
                            int newPagesRead = scan.nextInt();

                            // (1/2) Use of calculation method to add pages read.
                            selectedBook.addPagesRead(newPagesRead);
                            break;
                    }
                    break;

                // Discount a Book
                case 5:
                    // Print menu of numbered books.
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println(String.format("%o. %s", i + 1, books.get(i)));
                    }

                    // Prompt user to select line number of book they would like to discount.
                    System.out.println("Enter the line number of the book you would like to discount: ");
                    int bookIndex = scan.nextInt();
                    Book discountedBook = books.get(bookIndex - 1);

                    // Storing current price for later use below.
                    double currPrice = discountedBook.getPrice();
                    System.out.println(
                            "What percentage off would you like to apply? (Enter a whole decimal number! i.e. 55.5 or 55): ");
                    double percentageOff = scan.nextDouble();

                    // (2/2) Perform discount calculation. See Book class for specifics.
                    discountedBook.discountPrice(percentageOff);

                    // Print price before and after discount for user visibility.
                    System.out.println(String.format(
                            "Previous Price: %f, Discounted Price: %f\n", currPrice, discountedBook.getPrice()));

                    System.out.println("Press enter to exit");

                    // Hold current screen until user presses enter key.
                    System.in.read();
                    break;

                // Exit
                case 6:
                    // Update exit variable to "exit" to quit the program.
                    exit = "exit";
                    break;
            }
        }
    }
}
