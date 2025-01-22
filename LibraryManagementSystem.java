import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibraryManagementSystem {
    // Data structures for storing books and members
    private static final ArrayList<Book> books = new ArrayList<>();
    private static final ArrayList<Member> members = new ArrayList<>();
    private static final ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();
    private static int bookIdCounter = 1;
    private static int memberIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("\nWelcome to the Library Management System");
            System.out.println("-----------------------------------------");
            System.out.println("1. Book Management");
            System.out.println("2. Member Management");
            System.out.println("3. Borrow and Return");
            System.out.println("4. Reports");
            System.out.println("5. Search");
            System.out.println("6. Exit");
            System.out.println("-----------------------------------------");
            System.out.print("Enter your choice: ");
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    bookManagementMenu(scanner);
                    break;
                case 2:
                    memberManagementMenu(scanner);
                    break;
                case 3:
                    borrowAndReturnMenu(scanner);
                    break;
                case 4:
                    reportsMenu(scanner);
                    break;
                case 5:
                    searchMenu(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (mainChoice != 6);

        scanner.close();
    }

    // Book Management Menu
    private static void bookManagementMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nBook Management Menu");
            System.out.println("---------------------");
            System.out.println("1. Add New Book");
            System.out.println("2. Update Book Information");
            System.out.println("3. Delete Book");
            System.out.println("4. View All Books");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewBook(scanner);
                    break;
                case 2:
                    updateBookInfo(scanner);
                    break;
                case 3:
                    deleteBook(scanner);
                    break;
                case 4:
                    viewAllBooks();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 5);
    }

    private static void addNewBook(Scanner scanner) {
        System.out.print("\nEnter book title: ");
        scanner.nextLine(); // Consume newline
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        books.add(new Book(bookIdCounter++, title, author));
        System.out.println("Book added successfully!");
    }

    private static void updateBookInfo(Scanner scanner) {
        System.out.print("\nEnter the book ID to update: ");
        int id = scanner.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                System.out.print("Enter new title: ");
                scanner.nextLine(); // Consume newline
                book.setTitle(scanner.nextLine());
                System.out.print("Enter new author: ");
                book.setAuthor(scanner.nextLine());
                System.out.println("Book information updated successfully!");
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    private static void deleteBook(Scanner scanner) {
        System.out.print("\nEnter the book ID to delete: ");
        int id = scanner.nextInt();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    private static void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Member Management Menu
    private static void memberManagementMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nMember Management Menu");
            System.out.println("-----------------------");
            System.out.println("1. Add New Member");
            System.out.println("2. Update Member Information");
            System.out.println("3. Delete Member");
            System.out.println("4. View All Members");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewMember(scanner);
                    break;
                case 2:
                    updateMemberInfo(scanner);
                    break;
                case 3:
                    deleteMember(scanner);
                    break;
                case 4:
                    viewAllMembers();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 5);
    }

    // Member CRUD Methods
    private static void addNewMember(Scanner scanner) {
        System.out.print("\nEnter member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter member email: ");
        String email = scanner.nextLine();
    
        // Check if the ID is already taken
        for (Member member : members) {
            if (member.getId() == id) {
                System.out.println("A member with this ID already exists. Please try again.");
                return;
            }
        }
    
        members.add(new Member(id, name, email));
        System.out.println("Member added successfully!");
    }
    
    private static void updateMemberInfo(Scanner scanner) {
        System.out.print("\nEnter the member ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        for (Member member : members) {
            if (member.getId() == id) {
                System.out.print("Enter new name: ");
                member.setName(scanner.nextLine());
                System.out.print("Enter new email: ");
                member.setEmail(scanner.nextLine());
                System.out.println("Member information updated successfully!");
                return;
            }
        }
        System.out.println("Member with ID " + id + " not found.");
    }
    
    private static void deleteMember(Scanner scanner) {
        System.out.print("\nEnter the member ID to delete: ");
        int id = scanner.nextInt();
    
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == id) {
                members.remove(i);
                System.out.println("Member deleted successfully!");
                return;
            }
        }
        System.out.println("Member with ID " + id + " not found.");
    }
    
    private static void viewAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members available.");
        } else {
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }
    
    // Borrow and Return Menu
    // Borrow and Return Menu Implementation
private static void borrowAndReturnMenu(Scanner scanner) {
    int choice;
    do {
        System.out.println("\nBorrow and Return Menu");
        System.out.println("-----------------------");
        System.out.println("1. Borrow a Book");
        System.out.println("2. Return a Book");
        System.out.println("3. View Borrowed Books");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                borrowBook(scanner);
                break;
            case 2:
                returnBook(scanner);
                break;
            case 3:
                viewBorrowedBooks();
                break;
            case 4:
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    } while (choice != 4);
}

private static void borrowBook(Scanner scanner) {
    System.out.print("\nEnter member ID: ");
    int memberId = scanner.nextInt();
    System.out.print("Enter book ID to borrow: ");
    int bookId = scanner.nextInt();
    scanner.nextLine();  // Consume newline

    // Check if the member exists
    Member member = findMemberById(memberId);
    if (member == null) {
        System.out.println("Member not found.");
        return;
    }

    // Check if the book exists and is available
    Book book = findBookById(bookId);
    if (book == null) {
        System.out.println("Book not found.");
        return;
    }

    // Record the borrow date and add to borrow records
    System.out.print("Enter borrow date (YYYY-MM-DD): ");
    String borrowDate = scanner.nextLine();
    BorrowRecord borrowRecord = new BorrowRecord(bookId, memberId, borrowDate, null);
    borrowRecords.add(borrowRecord);
    System.out.println("Book borrowed successfully!");

    // Optionally, mark the book as unavailable by removing it or tracking the availability status
    // For simplicity, we won't remove the book here, but this can be added in future versions.
}

private static void returnBook(Scanner scanner) {
    System.out.print("\nEnter member ID: ");
    int memberId = scanner.nextInt();
    System.out.print("Enter book ID to return: ");
    int bookId = scanner.nextInt();
    scanner.nextLine();  // Consume newline

    // Find the borrow record for the book and member
    BorrowRecord borrowRecord = findBorrowRecord(memberId, bookId);
    if (borrowRecord == null) {
        System.out.println("No borrow record found for this book and member.");
        return;
    }

    // Ask for the return date
    System.out.print("Enter return date (YYYY-MM-DD): ");
    String returnDate = scanner.nextLine();
    borrowRecord.setReturnDate(returnDate);
    System.out.println("Book returned successfully!");
}

private static void viewBorrowedBooks() {
    if (borrowRecords.isEmpty()) {
        System.out.println("No books have been borrowed.");
    } else {
        for (BorrowRecord record : borrowRecords) {
            System.out.println(record);
        }
    }
}

// Helper Methods
private static Member findMemberById(int memberId) {
    for (Member member : members) {
        if (member.getId() == memberId) {
            return member;
        }
    }
    return null;
}

private static Book findBookById(int bookId) {
    for (Book book : books) {
        if (book.getId() == bookId) {
            return book;
        }
    }
    return null;
}

private static BorrowRecord findBorrowRecord(int memberId, int bookId) {
    for (BorrowRecord record : borrowRecords) {
        if (record.getMemberId() == memberId && record.getBookId() == bookId && record.getReturnDate() == null) {
            return record;
        }
    }
    return null;
}

// BorrowRecord Class (Updated)
static class BorrowRecord {
    private int bookId;
    private int memberId;
    private String borrowDate;
    private String returnDate;

    // Constructor
    public BorrowRecord(int bookId, int memberId, String borrowDate, String returnDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Member ID: " + memberId + ", Borrowed on: " + borrowDate + ", Returned on: " + (returnDate != null ? returnDate : "Not yet returned");
    }
}


    // Reports Menu
    private static void reportsMenu(Scanner scanner) {
    int choice;
    do {
        System.out.println("\nReports Menu");
        System.out.println("-------------");
        System.out.println("1. View Member Borrowing History");
        System.out.println("2. Back to Main Menu");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
            viewMemberBorrowingHistory(scanner);
                break;
            case 2:
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    } while (choice != 5);
}


private static void viewMemberBorrowingHistory(Scanner scanner) {
    System.out.print("\nEnter member ID: ");
    int memberId = scanner.nextInt();
    scanner.nextLine();  // Consume newline

    Member member = findMemberById(memberId);
    if (member == null) {
        System.out.println("Member not found.");
        return;
    }

    System.out.println("Borrowing History for Member: " + member.getName());
    boolean foundHistory = false;

    for (BorrowRecord record : borrowRecords) {
        if (record.getMemberId() == memberId) {
            Book book = findBookById(record.getBookId());
            System.out.println("Book: " + book.getTitle() + ", Borrowed on: " + record.getBorrowDate() + ", Returned on: " + (record.getReturnDate() != null ? record.getReturnDate() : "Not yet returned"));
            foundHistory = true;
        }
    }

    if (!foundHistory) {
        System.out.println("No borrowing history found for this member.");
    }
}


    // Search Menu
    private static void searchMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nSearch Menu");
            System.out.println("------------");
            System.out.println("1. Search Books by Title");
            System.out.println("2. Search Books by Author");
            System.out.println("3. Search Members by Name");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline after nextInt()
    
            switch (choice) {
                case 1:
                    searchBooksByTitle(scanner);
                    break;
                case 2:
                    searchBooksByAuthor(scanner);
                    break;
                case 3:
                    searchMembersByName(scanner);
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
    
        } while (choice != 4);
    }
    
    private static void searchBooksByTitle(Scanner scanner) {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine().toLowerCase();  // Case-insensitive search
    
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title)) {
                System.out.println("Found Book: " + book.getTitle() + " by " + book.getAuthor());
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("No books found with the title containing: " + title);
        }
    }
    
    private static void searchBooksByAuthor(Scanner scanner) {
        System.out.print("Enter author name to search: ");
        String author = scanner.nextLine().toLowerCase();  // Case-insensitive search
    
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author)) {
                System.out.println("Found Book: " + book.getTitle() + " by " + book.getAuthor());
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("No books found by the author: " + author);
        }
    }
    
    private static void searchMembersByName(Scanner scanner) {
        System.out.print("Enter member name to search: ");
        String name = scanner.nextLine().toLowerCase();  // Case-insensitive search
    
        boolean found = false;
        for (Member member : members) {
            if (member.getName().toLowerCase().contains(name)) {
                System.out.println("Found Member: " + member.getName());
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("No members found with the name containing: " + name);
        }
    }
    
    // Book Class
    static class Book {
        private int id;
        private String title;
        private String author;

        // Constructor
        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Title: " + title + ", Author: " + author;
        }
    }


    // Member Class
    static class Member {
        private int id;
        private String name;
        private String email;

        public Member(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Email: " + email;
        }
    }
}
