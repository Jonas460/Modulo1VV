package classes;

import java.util.ArrayList;
import java.util.List;

public class Borrower extends Person {
    private List<Book> borrowedBooks;

    public Borrower(String name) {
        super(name);
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        this.borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        this.borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean hasBorrowedBook(Book book) {
        return this.borrowedBooks.contains(book);
    }

    public boolean canBorrow() {
        return this.borrowedBooks.size() < 3; 
    }
}
