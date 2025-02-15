import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LastModifiedDate {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Public\\example.txt"); // Change to your file

        if (file.exists()) {
            long lastModified = file.lastModified();
            String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(lastModified));
            System.out.println("Last modified date: " + date);
        } else {
            System.out.println("File does not exist.");
        }
    }
}
