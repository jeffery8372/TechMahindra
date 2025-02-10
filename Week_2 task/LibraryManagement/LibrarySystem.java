import java.util.ArrayList;
import java.util.List;

public abstract class LibrarySystem implements ILibrary{
    List<Book> books;
    List<User> users;

    public LibrarySystem(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public abstract void addBook(Book book);
    public abstract void addUser(User user);

    @Override
    public Book searchBook(String title){
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getTitle().equalsIgnoreCase(title)){
                return books.get(i);
            }
        }
        return null;
    }
}
