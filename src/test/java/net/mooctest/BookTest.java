package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testCheckOut() {
        Book book = new Book("1234567890", "Test Book", "Test Author");
        assertFalse(book.isCheckedOut());
        
        book.checkOut();
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void testReturnBook() {
        Book book = new Book("1234567890", "Test Book", "Test Author");
        book.checkOut();
        assertTrue(book.isCheckedOut());
        
        book.returnBook();
        assertFalse(book.isCheckedOut());
    }
}