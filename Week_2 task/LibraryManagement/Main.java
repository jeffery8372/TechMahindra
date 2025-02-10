import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{
    public static void main(String[] args){
        LibraryManager libManager = new LibraryManager();

        libManager.addBook(new Book("Python Programming", "Charles", "17345"));
        libManager.addBook(new Book("DSA", "Steve", "67830"));
        libManager.addUser(new User("Arun", "U00005"));
        libManager.addUser(new User("Bobby", "U00005"));
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
