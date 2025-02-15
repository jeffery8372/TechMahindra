import java.io.File;

public class CheckFileExists {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Public\\example.txt"); // Change to your file

        if (file.exists()) {
            System.out.println("File or directory exists.");
        } else {
            System.out.println("File or directory does not exist.");
        }
    }
}
