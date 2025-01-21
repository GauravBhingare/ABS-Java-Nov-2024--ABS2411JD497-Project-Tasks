import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private final String title;
    private final String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Borrowed: " + (isBorrowed ? "Yes" : "No");
    }
}

// Library class
class Library {
    private final ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter the title of the book to borrow: ");
                    title = scanner.nextLine();
                    Book bookToBorrow = library.searchBook(title);
                    if (bookToBorrow != null && !bookToBorrow.isBorrowed()) {
                        bookToBorrow.borrowBook();
                        System.out.println("You have borrowed: " + bookToBorrow.getTitle());
                    } else if (bookToBorrow != null) {
                        System.out.println("Book is already borrowed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the title of the book to return: ");
                    title = scanner.nextLine();
                    Book bookToReturn = library.searchBook(title);
                    if (bookToReturn != null && bookToReturn.isBorrowed()) {
                        bookToReturn.returnBook();
                        System.out.println("You have returned: " + bookToReturn.getTitle());
                    } else if (bookToReturn != null) {
                        System.out.println("Book was not borrowed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
