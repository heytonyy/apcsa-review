public class Library {
    // Static variable for all libraries
    private static int totalBooks = 0;
    
    // Instance variables
    private String name;
    private int bookCount;
    
    // Constructor
    public Library(String name) {
        this.name = name;
        this.bookCount = 0;
    }
    
    // Method to add a book
    public void addBook(Book book) {
        bookCount++;
        totalBooks++;
    }
    
    // Static method to get total books across all libraries
    public static int getTotalBooks() {
        return totalBooks;
    }
    
    // Instance method to get books in this library
    public int getBookCount() {
        return bookCount;
    }
    
    // Getter for library name
    public String getName() {
        return name;
    }
    
    // toString method
    public String toString() {
        return name + " Library (" + bookCount + " books)";
    }
}
