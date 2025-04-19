public class LibraryRunner {
    public static void main(String[] args) {
        // Create books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780060935467");
        Book book3 = new Book("1984", "George Orwell", "9780451524935");
        
        // Create libraries
        Library central = new Library("Central");
        Library branch = new Library("Branch");
        
        // Add books to libraries
        central.addBook(book1);
        central.addBook(book2);
        branch.addBook(book3);
        
        // Display library information
        System.out.println(central);
        System.out.println(branch);
        System.out.println("Total books in all libraries: " + Library.getTotalBooks());
        
        // Check out a book
        if (book1.checkout()) {
            System.out.println(book1.getTitle() + " has been checked out.");
        }
        
        // Display updated book information
        System.out.println(book1);
        
        // Return the book
        book1.returnBook();
        System.out.println(book1);
    }
}