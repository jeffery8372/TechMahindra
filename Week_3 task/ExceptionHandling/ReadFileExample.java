import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileExample {
    public static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        System.out.println("File found and opened successfully.");
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            readFile("C:\\Users\\Public\\example.txt"); // Change to an existing/non-existing file
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: File not found.");
        }
    }
}
