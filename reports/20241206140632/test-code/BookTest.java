package net.mooctest;

import static org.junit.Assert.*;
import org.junit.Test;

public class BookTest {

    @Test
    public void testBookCheckOut() {
        Book book = new Book("1234567890", "Test Book", "Test Author");
        assertFalse(book.isCheckedOut());
        book.checkOut();
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void testBookReturn() {
        Book book = new Book("1234567890", "Test Book", "Test Author");
        book.checkOut();
        assertTrue(book.isCheckedOut());
        book.returnBook();
        assertFalse(book.isCheckedOut());
    }

    // Add more test cases as needed

}