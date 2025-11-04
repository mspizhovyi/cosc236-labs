package library;

public class LibrarianController {
    private final Library library;

    public LibrarianController() {
        this.library = new Library();
    }
	
    public String collectBook(String title, String author) {
        boolean success = library.addBook(title, author);
        return success ? "Book added successfully." : "Book already exists.";
    }

    public String removeBook(String title, String author) {
        boolean success = library.removeBook(title, author);
        return success ? "Book removed successfully." : "No such book found.";
    }

    public String borrowBook(String title, String author, String memberId) {
        boolean success = library.assignBookToMember(title, author, memberId);
        return success ? "Book borrowed successfully by " + memberId + "."
                       : "Borrow operation failed: book unavailable or member not found.";
    }

    public String returnBook(String title, String author, String memberId) {
        boolean success = library.returnBook(title, author, memberId);
        return success ? "Book returned successfully by " + memberId + "."
                       : "Return operation failed: book not found or already available.";
    }

    public void listBooks() {
        String info = library.listBooksInfo();
        System.out.println(info);
    }

    // -------------------- MEMBER OPERATIONS (Jun’s part) --------------------

    public String registerMember(String name) {
        // TODO (Jun): call library.registerMember(name) and return success/failure message
        return "Feature not implemented yet.";
    }

    public String removeMember(String name) {
        // TODO (Jun): call library.removeMember(name) and return success/failure message
        return "Feature not implemented yet.";
    }

    public void listMembers() {
        // TODO (Jun): get members info from library.listMembersInfo() and print it
    }
}
