import java.io.*;
import java.util.List;
//import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class LibraryManager extends LibrarySystem{
    private ReentrantLock lock = new ReentrantLock();

    public void addBook(Book book){
        books.add(book);
    }

    public void addUser(User user){
        users.add(user);
    }

    public void borrowBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException{
        lock.lock();
        try {
            Book book = null;
            User user = null;
            
            for (int i = 0; i < books.size(); i++){
                if (books.get(i).getISBN().equals(ISBN)){
                    book = books.get(i);
                    break;
                }
            }
            
            for (int i = 0; i < users.size(); i++){
                if (users.get(i).getUserID().equals(userID)){
                    user = users.get(i);
                    break;
                }
            }

            if (book == null) throw new BookNotFoundException("Book not found: " + ISBN);
            if (user == null) throw new UserNotFoundException("User not found: " + userID);
            
            user.borrowBook(book);
            books.remove(book);
            System.out.println(user.getName() + " borrowed " + book.getTitle());
        } 
        finally{
            lock.unlock();
        }
    }

    public void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException{
        lock.lock();
        try {
            User user = null;
            for (int i = 0; i < users.size(); i++){
                if (users.get(i).getUserID().equals(userID)){
                    user = users.get(i);
                    break;
                }
            }
            if (user == null) throw new UserNotFoundException("User not found: " + userID);

            Book book = null;
            for (int i = 0; i < user.getBorrowedBooks().size(); i++){
                if (user.getBorrowedBooks().get(i).getISBN().equals(ISBN)){
                    book = user.getBorrowedBooks().get(i);
                    break;
                }
            }

            if (book == null) throw new BookNotFoundException("Book not found in user's possession: " + ISBN);

            user.returnBook(book);
            books.add(book);
            System.out.println(user.getName() + " returned " + book.getTitle());
        }
         finally{
            lock.unlock();
        }
    }

    public void reserveBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException{
        lock.lock();
        try {
            Book book = searchBook(ISBN);
            if (book == null) throw new BookNotFoundException("Cannot reserve, book unavailable: " + ISBN);
            System.out.println("Reservation placed for " + book.getTitle() + " by member " + userID);
        } 
        finally{
            lock.unlock();
        }
    }

    public void saveLibraryData() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("library_data.ser"));
        out.writeObject(books);
        out.writeObject(users);
        out.close();
    }

    public void loadLibraryData() throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("library_data.ser"));
        books = (List<Book>) in.readObject();
        users = (List<User>) in.readObject();
        in.close();
    }
}
