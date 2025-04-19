public class BookCatalogRunner {
    public static void main(String[] args) {
        // Create a new book catalog
        BookCatalog library = new BookCatalog();
        
        // Add books
        library.addBook("To Kill a Mockingbird");
        library.addBook("1984");
        library.addBook("The Great Gatsby");
        library.addBook("Pride and Prejudice");
        library.addBook("The Catcher in the Rye");
        library.addBook("The Hobbit");
        
        // Display the catalog
        System.out.println("Initial catalog:");
        System.out.println(library);
        
        // Check out some books
        library.checkOut("1984");
        library.checkOut("The Hobbit");
        
        System.out.println("After check outs:");
        System.out.println(library);
        
        // Return a book
        library.returnBook("1984");
        
        System.out.println("After return:");
        System.out.println(library);
        
        // Find books by prefix
        ArrayList<String> tBooks = library.findBooksByPrefix("The");
        System.out.println("Books starting with 'The':");
        
        for (String book : tBooks) {
            System.out.println("- " + book);
        }
        
        // Remove a book
        library.removeBook("Pride and Prejudice");
        
        System.out.println("After removal:");
        System.out.println(library);
    }
}