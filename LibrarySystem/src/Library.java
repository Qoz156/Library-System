import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Library, which contains a collection of books.
 * It allows for adding, borrowing, reviewing, and returning books, and viewing
 * available books and reviews.
 *
 * It uses an ArrayList for storing books and reviews and a List for the user's collection
 * of borrowed books. The maximum number of books that can be borrowed is three.
 */
public class Library {

    private ArrayList<Book> books;              // List of books available in the library
    private ArrayList<Book> collection;         // List of books currently borrowed by the user
    private List<String> reviews;               // List of reviews for the books

    /**
     * Constructor for initializing the library with some default books.
     * It also initializes the collections for books and reviews.
     */
    public Library() {
        books = new ArrayList<>();
        collection = new ArrayList<>();
        reviews = new ArrayList<>();
        initialiseBooks();               // Add default books to the library when the library is created
    }

    /**
     * Initializes the library with a set of predefined books.
     */
    public void initialiseBooks() {
        // Create several book objects with title, author, year, and genre
        Book book1 = new Book("Animal Farm", "George Orwell", 1945, "Political satire");
        Book book2 = new Book("Pride and Prejudice", "Jane Austen", 1813, "Romance");
        Book book3 = new Book("Gregor the Over-lander", "Suzanne Collins", 2003, "Dystopian Adventure");
        Book book4 = new Book("To kill a mockingbird", "Harper Lee", 1960, "Southern gothic");
        Book book5 = new Book("The Canterbury Tales", "Geoffrey Chaucer", 1476, "Poetry");
        Book book6 = new Book("Diary of a wimpy kid", "Jeff Kinney", 2007, "Comedy");
        Book book7 = new Book("A tale of two cities", "Charles Dickens", 1859, "Historical fiction");
        Book book8 = new Book("And then there were none", "Agatha Christie", 1939, "Mystery");
        Book book9 = new Book("The tale of Peter Rabbit", "Beatrix Potter", 1902, "Children's literature");
        Book book10 = new Book("The lost symbol", "Dan Brown", 2009, "Fiction");

        // Add these books to the library's list of books
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);
    }

    /**
     * Displays a list of all books currently available in the library.
     * If there are no books, it prints a message indicating the library is empty.
     */
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("There are no books in the library");
        }
        else {
            for (Book book : books) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    /**
     * Allows the user to borrow a book from the library by title.
     * The user can borrow a maximum of three books at a time.
     *
     * @param title The title of the book the user wants to borrow.
     */
    public void borrowBook(String title) {
        boolean found = false;
        // Check if the user already has the maximum number of books
        if (collection.size() >= 3) {
            System.out.println("You can only borrow a maximum of three books.");
            return;
        }
        // Search through the library's books to find the matching title
        for (Book book : books) {
            if (title.equals(book.getTitle().toLowerCase().trim())) {
                books.remove(book);     // Remove the book from the library
                collection.add(book);   // Add it to the user's collection
                System.out.println("The book " + book.getTitle() + " has been borrowed");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("That book is not available in the library.");
        }

    }

    /**
     * Displays the information about a book, including its publication year and genre.
     *
     * @param info The title of the book whose information is requested.
     */
    public void informationRequest(String info) {
        boolean found = false;
        // Search for the book in the library
        for (Book book : books) {
            if (info.equals(book.getTitle().toLowerCase())) {
                // Print the year and genre of the found book
                System.out.println("The year of publication is: " + book.getYearOfPublication());
                System.out.println("The genre is: " + book.getGenre());
                found = true;
            }
        }
        if (!found) {
        System.out.println("That book is not available in the library.");
        }
    }

    /**
     * Displays all the books currently in the user's collection.
     * If the collection is empty, prompts the user to borrow a book first.
     */
    public void collectionRequest() {
        if (collection.isEmpty()) {
            System.out.println("There are no books in your collection. You need to borrow a book first.");
        }
        else {
            System.out.println("These are the books in your collection: ");
            // Display each book in the user's collection
            for (Book book : collection) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    /**
     * Allows the user to add a review for a book from the library.
     *
     * @param reviewTitle   The title of the book to review.
     * @param reviewContent The content of the review.
     */
    public void reviewRequest(String reviewTitle, String reviewContent) {
        boolean found = false;
        // Search for the book to add the review
        for (Book book : books) {
            if (reviewTitle.equals(book.getTitle().toLowerCase().trim())) {
                reviews.add(reviewContent); // Add the review to the list
                System.out.println("The review has been added to " + book.getTitle());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("That book is not available in the library.");
        }
    }

    /**
     * Displays all reviews for books in the library.
     * If there are no reviews, prompts the user to add a review.
     */
    public void viewReviews() {
        if (reviews.isEmpty()) {
            System.out.println("There are no reviews yet. Type 'add review' to add one.");
        }
        else {
            System.out.println("These are the reviews in your collection: ");
            // Display each review
            for (String review : reviews) {
                System.out.println(review);
            }
        }
    }

    /**
     * Allows the user to return a borrowed book to the library.
     *
     * @param returnTitle The title of the book to return.
     */
    public void returnRequest(String returnTitle) {
        boolean found = false;
        // Search through the user's collection to find the book to return
        for (Book book : collection) {
            if (book.getTitle().toLowerCase().trim().equals(returnTitle)) {
                    books.add(book);    // Add the book back to the library
                    collection.remove(book);    // Remove it from the user's collection
                    System.out.println("You have successfully returned " + book.getTitle());
                    found = true;
                    break;
                }
            }
        if (!found) {
            System.out.println("That book is not in your collection.");
        }

    }

}
