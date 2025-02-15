import java.io.File;
import java.util.Scanner;

public class CheckNegativeNumbers {
    public static void readNumbers(String filePath) throws Exception {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num > 0) {
                scanner.close();
                throw new Exception("Positive number found: " + num);
            }
        }

        System.out.println("All numbers are negative.");
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            readNumbers("C:\\Users\\Public\\numbers.txt"); // Change to your file path
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
