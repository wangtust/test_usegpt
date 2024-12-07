package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book1 = new Book("123", "Java Programming", "John Doe");
        
        library.addBook(book1);
        
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book1));
    }

    @Test
    public void testRemoveBook() {
        Library library = new Library();
        Book book1 = new Book("123", "Java Programming", "John Doe");
        
        library.addBook(book1);
        library.removeBook(book1);
        
        assertEquals(0, library.getBookCount());
        assertFalse(library.getBooks().contains(book1));
    }
}