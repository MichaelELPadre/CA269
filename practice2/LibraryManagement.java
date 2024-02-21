import java.util.*;

public class LibraryManagement {
    //Generic class (Represent Book) generics allow for different types of books
    static class Book<T> {
        private T bookId;
        private String title;

        public Book(T bookId, String title) {
            this.bookId = bookId;
            this.title = title;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        
        
        // HashSet to store available books in the library. Prevents duplicate books.
        Set<Book<Integer>> availableBooks = new HashSet<>();
        availableBooks.add(new Book<>(1, "Java Fundamentals"));
        availableBooks.add(new Book<>(2, "Data Structures in Java"));



        // ArrayList to track the history of all borrowed books. Allows duplicate entries.
        List<Book<Integer>> borrowedBooksHistory = new ArrayList<>();



        // HashMap to map a member's ID to the books they have borrowed. Enables fast lookups.
        Map<String, List<Book<Integer>>> borrowedBooksByMember = new HashMap<>();

        // LinkedList to manage a waiting list for a popular book. Ideal for queues.
        LinkedList<Book<Integer>> waitingListForBook = new LinkedList<>();

        // ArrayDeque to manage a stack of returned books. Efficient for adding/removing from both ends.
        Deque<Book<Integer>> returnedBooksStack = new ArrayDeque<>();

        // Simulate borrowing a book
        Book<Integer> borrowedBook = new Book<>(1, "Java Fundamentals");
        borrowedBooksHistory.add(borrowedBook);
        borrowedBooksByMember.computeIfAbsent("Member1", k -> new ArrayList<>()).add(borrowedBook);
        availableBooks.remove(borrowedBook);

        // Someone else wants the same book, added to waiting list
        waitingListForBook.add(borrowedBook);

        // Book returned and added to the stack of returned books
        returnedBooksStack.push(borrowedBook);

        // Process returned books
        while (!returnedBooksStack.isEmpty()) {
            Book<Integer> returnedBook = returnedBooksStack.pop();
            if (!waitingListForBook.isEmpty() && waitingListForBook.contains(returnedBook)) {
                waitingListForBook.remove(returnedBook);
                System.out.println("Book " + returnedBook + " is now available for the next person in the waiting list.");
            } else {
                availableBooks.add(returnedBook);
                System.out.println("Book " + returnedBook + " is now available for borrowing.");
            }
        }

        // Print available books
        System.out.println("Available books: " + availableBooks);
    }
}
