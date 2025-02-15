import java.io.File;
import java.io.FileNotFoundException;

public class CheckEmptyFile {
    public static void checkFile(String filePath) throws Exception {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundException("File not found.");
        }

        if (file.length() == 0) {
            throw new Exception("File is empty.");
        }

        System.out.println("File is not empty.");
    }

    public static void main(String[] args) {
        try {
            checkFile("C:\\Users\\Public\\example.txt"); // Change to your file path
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
