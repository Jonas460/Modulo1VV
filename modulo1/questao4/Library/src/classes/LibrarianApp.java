package classes;

import java.util.List;
import java.util.Scanner;

public class LibrarianApp {
    private static Library library = new Library();
    private static Librarian librarian = new Librarian("John Smith", library);

    public static void main(String[] args) {
        System.out.println("Welcome to the Library System");

        Book book1 = new Book("Java Programming", "John Doe", 2010);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Smith", 2015);
        Book book3 = new Book("Introduction to Databases", "Michael Brown", 2018);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. List all books");
            System.out.println("2. Search books");
            System.out.println("3. Add a book");
            System.out.println("4. Remove a book");
            System.out.println("5. Borrow a book");
            System.out.println("6. Return a book");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    listAllBooks();
                    break;
                case 2:
                    searchBooks(scanner);
                    break;
                case 3:
                    addBook(scanner);
                    break;
                case 4:
                    removeBook(scanner);
                    break;
                case 5:
                    borrowBook(scanner);
                    break;
                case 6:
                    returnBook(scanner);
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void listAllBooks() {
        List<Book> books = library.getBooks();
        if (books.isEmpty()) {
            System.out.println("There are no books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println("- " + book.toString());
            }
        }
    }

    private static void searchBooks(Scanner scanner) {
        System.out.print("Enter a search query: ");
        String query = scanner.nextLine();
        List<Book> results = library.searchBooks(query);
        if (results.isEmpty()) {
            System.out.println("No results found for query \"" + query + "\".");
        } else {
            System.out.println("Results for query \"" + query + "\":");
            for (Book book : results) {
                System.out.println("- " + book.toString());
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the book year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 
        Book book = new Book(title, author, year);
        librarian.addBook(book);
        System.out.println("Book \"" + book.toString() + "\" added to the library.");
    }

    private static void removeBook(Scanner scanner) {
        System.out.print("Enter the ID of the book to remove: ");
        int bookId = scanner.nextInt();
        library.removeBook(bookId);
        System.out.println("Book with ID " + bookId + " removed.");
    }

    private static void borrowBook(Scanner scanner) {
        System.out.print("Enter the ID of the book to borrow: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your name: ");
        String borrowerName = scanner.nextLine();
        Borrower borrower = new Borrower(borrowerName);
        boolean success = librarian.borrowBook(bookId, borrower);
        if (success) {
            System.out.println("Book with ID " + bookId + " borrowed by " + borrower.getName() + ".");
        } else {
            System.out.println("No book found with ID " + bookId + ".");
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Enter the ID of the book to return: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); 
        boolean success = librarian.returnBook(bookId);
        if (success) {
            System.out.println("Book with ID " + bookId + " returned to the library.");
        } else {
            System.out.println("No book found with ID " + bookId + ".");
        }
    }
}