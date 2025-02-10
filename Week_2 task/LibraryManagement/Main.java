import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{
    public static void main(String[] args){
        LibraryManager libManager = new LibraryManager();

        libManager.addBook(new Book("Java Programming", "James", "12345"));
        libManager.addBook(new Book("Data Structures and Algorithms", "Smith", "67890"));
        libManager.addUser(new User("Alice", "U00001"));
        libManager.addUser(new User("Bob", "U00002"));
        //libManager.borrowBook("sssssa", "sdssddddsa");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new Runnable(){
            public void run(){
                try { 
                    libManager.borrowBook("67890", "U00001"); 
                } 
                catch (Exception e){ 
                    System.err.println(e.getMessage()); 
                }
            }
        });

        executor.execute(new Runnable(){
            public void run(){
                try { 
                    libManager.returnBook("67890", "U00001");
                } 
                catch (Exception e){ 
                    System.err.println(e.getMessage()); 
                }
            }
        });
        executor.shutdown();
    }
}
