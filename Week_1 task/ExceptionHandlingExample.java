
import java.util.Scanner;

public class ExceptionHandlingExample {

    public static void main(String[] args) {
        processInput();
    }

    // Method to process user input and handle exceptions
    public static void processInput() {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Prompt the user for a number
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();
            
            // Try to parse the input to a double
            double number = Double.parseDouble(input);
            
            // Check if the number is zero and handle division by zero
            if (number == 0) {
                throw new ArithmeticException("Cannot calculate reciprocal of zero.");
            }
            
            // Calculate and print the reciprocal
            double reciprocal = 1 / number;
            System.out.println("The reciprocal of " + number + " is: " + reciprocal);
            
        } catch (NumberFormatException e) {
            // Handle the case when the input is not a valid number
            System.out.println("Invalid input! Please enter a valid number.");
            
        } catch (ArithmeticException e) {
            // Handle the case when the number is zero
            System.out.println(e.getMessage());
            
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Close the scanner object
            System.out.println("Processing complete.");

        }
}
}
