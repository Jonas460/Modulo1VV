package classes;


public class Librarian extends Person {
    private Library library;

    public Librarian(String name, Library library) {
        super(name);
        this.library = library;
    }

    public void addBook(Book book) {
        this.library.addBook(book);
    }

    public Library getLibrary() {
        return library;
    }

	public boolean borrowBook(int bookId, Borrower borrower) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean returnBook(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeBook(int bookId, Library library) {
        library.removeBook(bookId);
    }
}
