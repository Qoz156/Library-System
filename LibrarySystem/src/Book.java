/**
 * This class represents a Book object with attributes such as title, author,
 * year of publication, and genre. It provides getter methods to retrieve
 * the values of these attributes.
 *
 * The Book class is used to store information about a book, which can be
 * added to a library or borrowed by a user.
 */
public class Book {
    private String title;                // The title of the book
    private String author;               // The author of the book
    private int yearOfPublication;       // The year the book was published
    private String genre;                // The genre of the book

    /**
     * Constructor to initialize a new Book object with a given title, author,
     * year of publication, and genre.
     *
     * @param title            The title of the book
     * @param author           The author of the book
     * @param yearOfPublication The year the book was published
     * @param genre            The genre of the book
     */
    public Book(String title, String author, int yearOfPublication, String genre) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
    }

    /**
     * Returns the title of the book.
     *
     * @return The title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     *
     * @return The author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the year of publication for the book.
     *
     * @return The year of publication
     */
    public int getYearOfPublication() {
        return yearOfPublication;
    }

    /**
     * Returns the genre of the book.
     *
     * @return The genre of the book (e.g., fiction, mystery, etc.)
     */
    public String getGenre() {
        return genre;
    }

}
