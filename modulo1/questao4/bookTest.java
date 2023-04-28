import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BookTest {
    @Test
    public void testConstructor() {
        Book book = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        assertEquals("The Lord of the Rings", book.getTitle());
        assertEquals("J.R.R. Tolkien", book.getAuthor());
        assertEquals(1954, book.getYear());
    }

    @Test
    public void testSetTitle() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        book.setTitle("The Lord of the Rings");
        assertEquals("The Lord of the Rings", book.getTitle());
    }

    @Test
    public void testSetAuthor() {
        Book book = new Book("The Silmarillion", "J.R.R. Tolkien", 1977);
        book.setAuthor("Christopher Tolkien");
        assertEquals("Christopher Tolkien", book.getAuthor());
    }

    @Test
    public void testSetYear() {
        Book book = new Book("The Children of Húrin", "J.R.R. Tolkien", 2007);
        book.setYear(1977);
        assertEquals(1977, book.getYear());
    }

    @Test
    public void testToString() {
        Book book = new Book("The Fall of Gondolin", "J.R.R. Tolkien", 2018);
        String expected = "The Fall of Gondolin by J.R.R. Tolkien, published in 2018";
        assertEquals(expected, book.toString());
    }
}