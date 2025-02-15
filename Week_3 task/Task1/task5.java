import java.util.Scanner;

public class task5{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Calling method to convert
        String result = capitalizeAlternate(input);

        // Displaying output
        System.out.println("Output: " + result);

        scanner.close();
    }

    public static String capitalizeAlternate(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                sb.append(Character.toUpperCase(str.charAt(i))); // Capitalize even index
            } else {
                sb.append(Character.toLowerCase(str.charAt(i))); // Keep odd index lowercase
            }
        }

        return sb.toString();
    }
}
