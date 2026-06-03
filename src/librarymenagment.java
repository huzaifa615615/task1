import java.util.TreeSet;

public class librarymenagment {

    private TreeSet<String> books;

    public librarymenagment() {
        books = new TreeSet<>();
    }
    public void addBook(String title) {
        if (books.add(title)) {
            System.out.println("Book added: " + title);
        } else {
            System.out.println("Book already exists: " + title);
        }
    }
    public void removeBook(String title) {
        if (books.remove(title)) {
            System.out.println("Book removed: " + title);
        } else {
            System.out.println("Book not found: " + title);
        }
    }
    public boolean isBookAvailable(String title) {
        return books.contains(title);
    }
    public void displayAllBooks() {
        System.out.println("Library Collection:");
        for (String book : books) {
            System.out.println(book);
        }
    }
    public void findBooksStartingWith(char letter) {
        System.out.println("Books starting with '" + letter + "':");

        boolean found = false;
        for (String book : books) {
            if (!book.isEmpty() &&
                    Character.toUpperCase(book.charAt(0)) ==
                            Character.toUpperCase(letter)) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found.");
        }
    }
    public static void main(String[] args) {
        librarymenagment library = new librarymenagment();

        library.addBook("Harry Potter");
        library.addBook("The Hobbit");
        library.addBook("A Tale of Two Cities");
        library.addBook("Harry Potter"); // Duplicate

        library.displayAllBooks();

        System.out.println("\nIs 'The Hobbit' available? "
                + library.isBookAvailable("The Hobbit"));

        library.removeBook("The Hobbit");

        System.out.println("\nIs 'The Hobbit' available? "
                + library.isBookAvailable("The Hobbit"));

        library.findBooksStartingWith('H');

        library.displayAllBooks();
    }
}