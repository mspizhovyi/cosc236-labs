package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {

    private final List<Book> catalog = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    public Library() {}

    public boolean addBook(String title, String author) {
        if (findBook(title, author).isPresent()) return false;
        catalog.add(new Book(title, author));
        return true;
    }

    public boolean removeBook(String title, String author) {
        Optional<Book> book = findBook(title, author);
        if (book.isEmpty()) return false;
        catalog.remove(book.get());
        return true;
    }

    public Optional<Book> findBook(String title, String author) {
        return catalog.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title)
                        && b.getAuthor().equalsIgnoreCase(author))
                .findFirst();
    }

    public String listBooksInfo() {
        if (catalog.isEmpty()) return "No books in catalog.";
        StringBuilder sb = new StringBuilder("Book Catalog:\n");
        for (Book book : catalog) {
            sb.append("- ").append(book).append("\n");
        }
        return sb.toString();
    }

    public boolean assignBookToMember(String title, String author, String memberId) {
        Optional<Book> bookOpt = findBook(title, author);
        if (bookOpt.isEmpty()) return false;

        Book book = bookOpt.get();
        if (!book.isAvailable()) return false;

        // TODO (Jun): after Member logic is done, find the member and call member.borrowBook(book)
        book.setAvailable(false);
        return true;
    }

    public boolean returnBook(String title, String author, String memberId) {
        Optional<Book> bookOpt = findBook(title, author);
        if (bookOpt.isEmpty()) return false;

        Book book = bookOpt.get();
        if (book.isAvailable()) return false;

        // TODO (Jun): after Member logic is done, find the member and call member.returnBook(book)
        book.setAvailable(true);
        return true;
    }

    // -------------------- MEMBER MANAGEMENT (Jun’s part) --------------------

    public boolean registerMember(String name) {
        // TODO (Jun): create new Member and add to members list if not already exists
        return false;
    }

    public boolean removeMember(String name) {
        // TODO (Jun): find Member by name and remove from members list
        return false;
    }

    public Optional<Member> findMember(String name) {
        // TODO (Jun): search members list for a matching name (ignore case)
        return Optional.empty();
    }

    public String listMembersInfo() {
        // TODO (Jun): return a string with all members and their borrowed books
        return "No members found.";
    }
}
