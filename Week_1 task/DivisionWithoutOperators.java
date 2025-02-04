
import java.util.Scanner;

public class DivisionWithoutOperators {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: two numbers
        System.out.print("Enter the dividend: ");
        int dividend = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Edge case: If the divisor is 0
        if (divisor == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return;
        }

        // Find quotient using repeated subtraction
        int quotient = 0;
        int remainder = dividend;

        // Subtract divisor from dividend until remainder is less than divisor
        while (remainder >= divisor) {
            remainder = subtract(remainder, divisor);
            quotient = add(quotient, 1);
        }

        // Output the quotient and remainder
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }

    // Method to add two numbers
    public static int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public static int subtract(int a, int b) {
        return a-b;
    }
}
