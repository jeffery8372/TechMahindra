import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
    private String name;
    private String userID;
    private List<Book> borrowedBooks;
    private static final int MAX_BOOKS = 3;

    public User(String name, String userID){
        this.name = name;
        this.userID = userID;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName(){
         return name; 
    }
    public String getUserID(){ 
        return userID;
    }
    public List<Book> getBorrowedBooks(){ 
        return borrowedBooks; 
    }

    public void borrowBook(Book book) throws MaxBooksAllowedException{
        if (borrowedBooks.size() >= MAX_BOOKS){
            throw new MaxBooksAllowedException("User " + name + " has reached the borrowing limit.");
        }
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return name + " (ID: " + userID + ")";
    }
}
