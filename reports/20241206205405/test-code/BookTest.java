package net.mooctest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BookTest {

    @Test
    public void testCheckOut() {
        Book book = new Book("12345", "Test Book", "Test Author");
        
        assertFalse(book.isCheckedOut());
        
        book.checkOut();
        
        assertTrue(book.isCheckedOut());
        
        try {
            book.checkOut();
        } catch (IllegalStateException e) {
            assertEquals("Book is already checked out.", e.getMessage());
        }
    }

    @Test
    public void testReturnBook() {
        Book book = new Book("12345", "Test Book", "Test Author");
        
        assertFalse(book.isCheckedOut());
        
        try {
            book.returnBook();
        } catch (IllegalStateException e) {
            assertEquals("Book is not checked out.", e.getMessage());
        }
        
        book.checkOut();
        assertTrue(book.isCheckedOut());
        
        book.returnBook();
        assertFalse(book.isCheckedOut());
        
        try {
            book.returnBook();
        } catch (IllegalStateException e) {
            assertEquals("Book is not checked out.", e.getMessage());
        }
    }
}