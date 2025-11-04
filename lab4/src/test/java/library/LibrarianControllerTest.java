package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibrarianControllerTest {

    private LibrarianController controller;

    @BeforeEach
    void setUp() {
        controller = new LibrarianController();
    }

    @Test
    void shouldAddNewBookSuccessfully() {
        String result = controller.collectBook("Clean Code", "Robert Martin");
        assertEquals("Book added successfully.", result);
    }

    @Test
    void shouldRejectDuplicateBook() {
        controller.collectBook("Clean Code", "Robert Martin");
        String result = controller.collectBook("Clean Code", "Robert Martin");
        assertEquals("Book already exists.", result);
    }

    @Test
    void shouldRemoveExistingBook() {
        controller.collectBook("Clean Architecture", "Robert Martin");
        String result = controller.removeBook("Clean Architecture", "Robert Martin");
        assertEquals("Book removed successfully.", result);
    }

    @Test
    void shouldFailToRemoveNonexistentBook() {
        String result = controller.removeBook("Unknown Title", "No Author");
        assertEquals("No such book found.", result);
    }

    @Test
    void shouldBorrowBookWhenAvailable() {
        controller.collectBook("The Pragmatic Programmer", "Andy Hunt");
        // Member logic not implemented yet, but we can test book-only behavior
        String result = controller.borrowBook("The Pragmatic Programmer", "Andy Hunt", "DummyMember");
        assertTrue(result.contains("Book borrowed successfully"));
    }

    @Test
    void shouldFailBorrowWhenBookAlreadyBorrowed() {
        controller.collectBook("Refactoring", "Martin Fowler");
        controller.borrowBook("Refactoring", "Martin Fowler", "Alice");
        String result = controller.borrowBook("Refactoring", "Martin Fowler", "AnotherMember");
        assertEquals("Borrow operation failed: book unavailable or member not found.", result);
    }

    @Test
    void shouldListBooksAfterAdding() {
        controller.collectBook("Test Book", "Author");
        controller.collectBook("Another Book", "Writer");

        var outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));
        controller.listBooks();
        
        String printed = outputStream.toString();
        assertTrue(printed.contains("Test Book"));
        assertTrue(printed.contains("Another Book"));
    }

    // -------------------------------------------------------------
    // 🚧 FUTURE TESTS (commented out until Member logic is added)
    // -------------------------------------------------------------
    /*
    @Test
    void shouldBorrowBookWithRealMemberOnceImplemented() {
        controller.collectBook("Clean Coder", "Robert Martin");
        controller.registerMember("Alice");
        String result = controller.borrowBook("Clean Coder", "Robert Martin", "Alice");
        assertTrue(result.contains("Book borrowed successfully"));
    }

    @Test
    void shouldReturnBookOnceMemberLogicIsImplemented() {
        controller.collectBook("Domain-Driven Design", "Eric Evans");
        controller.registerMember("Bob");
        controller.borrowBook("Domain-Driven Design", "Eric Evans", "Bob");
        String result = controller.returnBook("Domain-Driven Design", "Eric Evans", "Bob");
        assertTrue(result.contains("Book returned successfully"));
    }
    */
}
