package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("123", "Sample Title", "Sample Author");
        library.addBook(book);
        
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book));
    }

    @Test
    public void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("123", "Sample Title", "Sample Author");
        library.addBook(book);

        // validate book is in library before removal
        assertTrue(library.getBooks().contains(book));
        
        library.removeBook(book);
        
        assertEquals(0, library.getBookCount());
        assertFalse(library.getBooks().contains(book));
    }
}