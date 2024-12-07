package net.mooctest;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private boolean isCheckedOut;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void checkOut() {
        if (isCheckedOut) {
            throw new IllegalStateException("Book is already checked out.");
        }
        isCheckedOut = true;
    }

    public void returnBook() {
        if (!isCheckedOut) {
            throw new IllegalStateException("Book is not checked out.");
        }
        isCheckedOut = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                '}';
    }
}