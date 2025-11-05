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

    public String registerMember(String name) {
        boolean ok = library.registerMember(name);
        return ok ? "Member registered: " + name
                  : "Member registration failed (duplicate or invalid name).";
    }

    public String removeMember(String name) {
        boolean ok = library.removeMember(name);
        return ok ? "Member removed: " + name
                  : "Member removal failed (not found or has borrowed books).";
    }

    public void listMembers() {
        System.out.println(library.listMembersInfo());
    }
}
