package classes;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                books.remove(book);
                return;
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean hasBook(Book book) {
        return this.books.contains(book);
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : this.books) {
            if (book.getTitle().contains(query) || book.getAuthor().contains(query)) {
                results.add(book);
            }
        }
        return results;
    }
}
