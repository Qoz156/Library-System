import java.util.Scanner;

/**
 * This is the main class of the Library System application.
 * It allows the user to interact with the library system by providing a command-line interface.
 * The user can view available books, borrow and return books, view details of books,
 * add reviews, and see reviews of books they have interacted with.
 */
public class Main {
    public static void main(String[] args) {

        Library myLibrary = new Library();  // Create a new Library object

        Scanner scanner = new Scanner(System.in);   // Create a scanner object for user input

        // Display the welcome message and instructions for the user
        System.out.println("Welcome to the Library System!");
        System.out.println("Type 'view' to see the list of available books.");
        System.out.println("Type 'borrow' to borrow a book.");
        System.out.println("Type 'return' to return a book.");
        System.out.println("Type 'information' to see further details.");
        System.out.println("Type 'add review' to add a review.");
        System.out.println("Type 'view reviews' to see all reviews.");
        System.out.println("Type 'collection' to see which books you have borrowed.");
        System.out.println("Type 'exit' to leave.");
        System.out.println();

        // Infinite loop to keep the program running until 'exit' is typed
        while (true) {
            // Prompt the user to enter a command
            System.out.println("Enter a command: 'view', 'borrow', 'return', 'information', 'add review', 'view reviews', 'collection', or 'exit'");
            System.out.println();
            String command = scanner.nextLine().toLowerCase().trim();   // Read the user input and convert it to lowercase

            // Based on the user's input, call the appropriate method from the Library object
            if (command.equals("view")) {
                myLibrary.viewBooks();  // View all available books
            }
            else if (command.equals("borrow")) {
                // Prompt the user to enter the title of the book they want to borrow
                System.out.println("Enter the name of the book you wish to borrow");
                String title = scanner.nextLine().toLowerCase().trim();
                myLibrary.borrowBook(title);    // Borrow the specified book
            }
            else if (command.equals("information")) {
                // Prompt the user to enter the title of the book they want more information about
                System.out.println("Enter the name of the book you want further details on.");
                String info = scanner.nextLine().toLowerCase().trim();
                myLibrary.informationRequest(info); // Show the book's information
            }
            else if (command.equals("collection")) {
                myLibrary.collectionRequest();  // View the user's borrowed books
            }
            else if (command.equals("return")) {
                // Prompt the user to enter the title of the book they want to return
                System.out.println("Enter the name of the book you wish to return");
                String returnTitle = scanner.nextLine().toLowerCase().trim();
                myLibrary.returnRequest(returnTitle);   // Return the specified book
            }
            else if (command.equals("add review")) {
                // Prompt the user to enter the title of the book they want to review
                System.out.println("Enter the name of the book you wish to review");
                String reviewTitle = scanner.nextLine().toLowerCase().trim();
                // Prompt the user to enter the review content
                System.out.println("Enter your review for the book: ");
                String reviewContent = scanner.nextLine().toLowerCase().trim();
                myLibrary.reviewRequest(reviewTitle, reviewContent);    // Add the review for the book
            }
            else if (command.equals("view reviews")) {
                myLibrary.viewReviews();    // View all reviews in the system
            }
            else if (command.equals("exit")) {
                System.out.println("Goodbye!");
                break;  // Exit the loop and terminate the program
            }
            else {
                System.out.println("Invalid command. Please try again.");   // Handle invalid commands
            }
        }

        scanner.close();    // Close the scanner object when done

    }

}

