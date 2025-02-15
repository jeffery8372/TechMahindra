import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadPlainTextFile {
    public static void main(String[] args) {
        File file = new File("\"C:\\Users\\jeffe\\Downloads\\sample.txt.txt\""); // Change to your file

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
