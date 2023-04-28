import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

public class BookTestAssertEquals {

    @Test
    void testConstructor() {
        String title = "To Kill a Mockingbird";
        String author = "Harper Lee";
        int year = 1960;
        Book book = new Book(title, author, year);

        assertAll("book",
                () -> assertEquals(title, book.getTitle()),
                () -> assertEquals(author, book.getAuthor()),
                () -> assertEquals(year, book.getYear()));
    }

    @Test
    void testSettersAndGetters() {
        Book book = new Book("1984", "George Orwell", 1949);
        String newTitle = "Animal Farm";
        String newAuthor = "George Orwell";
        int newYear = 1945;
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setYear(newYear);

        assertAll("book",
                () -> assertEquals(newTitle, book.getTitle()),
                () -> assertEquals(newAuthor, book.getAuthor()),
                () -> assertEquals(newYear, book.getYear()));
    }

    @Test
    void testToString() {
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";
        int year = 1925;
        Book book = new Book(title, author, year);

        String expected = "The Great Gatsby by F. Scott Fitzgerald, published in 1925";
        assertEquals(expected, book.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book book3 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);

        assertAll("book",
                () -> assertTrue(book1.equals(book2) && book2.equals(book1)),
                () -> assertFalse(book1.equals(book3) && book3.equals(book1)),
                () -> assertEquals(book1.hashCode(), book2.hashCode()));
    }

    @Test
    void testCompareTo() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("The Bell Jar", "Sylvia Plath", 1963);

        assertAll("book",
                () -> assertTrue(book1.compareTo(book2) < 0),
                () -> assertTrue(book2.compareTo(book3) < 0),
                () -> assertTrue(book1.compareTo(book3) < 0));
    }
}