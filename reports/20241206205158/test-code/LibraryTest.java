package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Title", "Author", "ISBN");
        library.addBook(book);
        assertEquals(1, library.getBookCount());
    }

    @Test
    public void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("Title", "Author", "ISBN");
        library.addBook(book);
        library.removeBook(book);
        assertEquals(0, library.getBookCount());
    }
}