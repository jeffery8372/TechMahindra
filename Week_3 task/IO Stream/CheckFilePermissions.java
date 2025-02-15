import java.io.File;

public class CheckFilePermissions {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Public\\example.txt"); // Change to your file

        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
    }
}
