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
        if(book == null) 
            return System.out.println(book.getName() + " does not exist in the library.");
        if(!borrowedBooks.contains(book))
            borrowedBooks.add(book);

    }

    public void returnBook(Book book) {
        if(book == null)
            return System.out.println(book.getName() + " does not exist in the library.");
        if(borrowedBooks.contains(book))
            borrowedBooks.remove(book)
    }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    @Override
    public String toString() {
       return String.format("Member{name='%s', borrowed=%d}", name, borrowedBooks.size());
    }
}
