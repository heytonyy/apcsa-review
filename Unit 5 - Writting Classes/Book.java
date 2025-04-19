public class Book {
    // Instance variables
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    
    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // New books are initially available
    }
    
    // Accessor methods
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Method to check out the book
    public boolean checkout() {
        if (isAvailable) {
            isAvailable = false;
            return true; // Successfully checked out
        }
        return false; // Book was not available
    }
    
    // Method to return the book
    public void returnBook() {
        isAvailable = true;
    }
    
    // toString method
    public String toString() {
        String status = "Available";
        if (!isAvailable) {
            status = "Checked Out";
        }
        return "\"" + title + "\" by " + author + " (ISBN: " + isbn + ") - " + status;
    }
}