import java.io.File;

public class CheckFileType {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Public\\example.txt"); // Change to your file

        if (file.isDirectory()) {
            System.out.println("It is a directory.");
        } else if (file.isFile()) {
            System.out.println("It is a file.");
        } else {
            System.out.println("Invalid pathname.");
        }
    }
}
