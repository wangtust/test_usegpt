package net.mooctest;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        books.add(book);
    }

    public void removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (!books.contains(book)) {
            throw new IllegalArgumentException("Book not found in library.");
        }
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getBookCount() {
        return books.size();
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}