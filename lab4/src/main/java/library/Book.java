// package lab4.library;
package library;

// import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private boolean available = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%s)",
                title, author, available ? "Available" : "Borrowed");
    }
}
