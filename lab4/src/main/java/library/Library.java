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

        Optional<Member> memberOpt = findMember(memberId);
        if (memberOpt.isEmpty()) return false;

        Member member = memberOpt.get();
        member.borrowBook(book);
        book.setAvailable(false);
        return true;
    }

    public boolean returnBook(String title, String author, String memberId) {
        Optional<Book> bookOpt = findBook(title, author);
        if (bookOpt.isEmpty()) return false;

        Book book = bookOpt.get();
        if (book.isAvailable()) return false;

        Optional<Member> memberOpt = findMember(memberId);
        if (memberOpt.isEmpty()) return false;

        Member member = memberOpt.get();
        member.returnBook(book);
        book.setAvailable(true);
        return true;
    }

    public boolean registerMember(String name) {
        if (name == null || name.isBlank()) return false;
        if (findMember(name).isPresent()) return false;
            members.add(new Member(name.trim()));
        return true;
    }

    public boolean removeMember(String name) {
        Optional<Member> mOpt = findMember(name);
        if (mOpt.isEmpty()) return false;

        Member m = mOpt.get();
        if (!m.getBorrowedBooks().isEmpty()) {
            return false;
        }
        members.remove(m);
        return true;
    }

    public Optional<Member> findMember(String name) {
        if (name == null) return Optional.empty();
        String target = name.trim();
        return members.stream()
                .filter(m -> m.getName().equalsIgnoreCase(target))
                .findFirst();
    }

    public String listMembersInfo() {
        if (members.isEmpty())
            return "No members found.";
        StringBuilder sb = new StringBuilder("Members:\n");
        for (Member m : members) {
            sb.append("- ").append(m.getName())
              .append(" | borrowed: ").append(m.getBorrowedBooks().size());
            if (!m.getBorrowedBooks().isEmpty()) {
                sb.append(" [");
                for (int i = 0; i < m.getBorrowedBooks().size(); i++) {
                    Book b = m.getBorrowedBooks().get(i);
                    sb.append(b.getTitle()).append(" by ").append(b.getAuthor());
                    if (i < m.getBorrowedBooks().size() - 1) sb.append("; ");
                }
                sb.append("]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
