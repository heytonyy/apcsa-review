import java.util.ArrayList;

public class BookCatalog {
    // Instance variables
    private ArrayList<String> availableBooks;
    private ArrayList<String> checkedOutBooks;
    
    // Constructor
    public BookCatalog() {
        availableBooks = new ArrayList<String>();
        checkedOutBooks = new ArrayList<String>();
    }
    
    // Method to add a book
    public void addBook(String title) {
        availableBooks.add(title);
    }
    
    // Method to remove a book
    public boolean removeBook(String title) {
        // Try to remove from available books
        boolean removed = availableBooks.remove(title);
        
        // If not found in available books, try checked out books
        if (!removed) {
            removed = checkedOutBooks.remove(title);
        }
        
        return removed;
    }
    
    // Method to get the number of available books
    public int getAvailableCount() {
        return availableBooks.size();
    }
    
    // Method to get the number of checked out books
    public int getCheckedOutCount() {
        return checkedOutBooks.size();
    }
    
    // Method to check out a book
    public boolean checkOut(String title) {
        int index = availableBooks.indexOf(title);
        
        if (index >= 0) {
            // Remove from available books
            availableBooks.remove(index);
            
            // Add to checked out books
            checkedOutBooks.add(title);
            return true;
        }
        
        return false; // Book not found or already checked out
    }
    
    // Method to return a book
    public boolean returnBook(String title) {
        int index = checkedOutBooks.indexOf(title);
        
        if (index >= 0) {
            // Remove from checked out books
            checkedOutBooks.remove(index);
            
            // Add back to available books
            availableBooks.add(title);
            return true;
        }
        
        return false; // Book not found in checked out books
    }
    
    // Method to search books by prefix
    public ArrayList<String> findBooksByPrefix(String prefix) {
        ArrayList<String> matches = new ArrayList<String>();
        
        // Check all available books
        for (String book : availableBooks) {
            if (book.length() >= prefix.length() && 
                book.substring(0, prefix.length()).equalsIgnoreCase(prefix)) {
                matches.add(book);
            }
        }
        
        // Check all checked out books
        for (String book : checkedOutBooks) {
            if (book.length() >= prefix.length() && 
                book.substring(0, prefix.length()).equalsIgnoreCase(prefix)) {
                matches.add(book);
            }
        }
        
        return matches;
    }
    
    // Method to get a string representation of the catalog
    public String toString() {
        String result = "Available Books (" + availableBooks.size() + "):\n";
        
        for (String book : availableBooks) {
            result += "- " + book + "\n";
        }
        
        result += "\nChecked Out Books (" + checkedOutBooks.size() + "):\n";
        
        for (String book : checkedOutBooks) {
            result += "- " + book + "\n";
        }
        
        return result;
    }
}
