package library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String name;
    private final List<Book> borrowedBooks = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        // TODO (Jun): add this book to borrowedBooks list

    }

    public void returnBook(Book book) {
        // TODO (Jun): remove this book from borrowedBooks list
       
    }

    public List<Book> getBorrowedBooks() {
        // TODO (Jun): return a copy of borrowedBooks
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        // TODO (Jun): display member name and number of borrowed books
       return "";
    }
}
