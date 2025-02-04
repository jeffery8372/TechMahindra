
public class TrailingZeroes {

    // Method to count trailing zeroes in factorial of a number
    public static int countTrailingZeroes(int n) {
        int count = 0;
        
        // Divide n by powers of 5 and update count
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        
        return count;
    }

    public static void main(String[] args) {
        int num = 100; // Example number
        int result = countTrailingZeroes(num);
        System.out.println("The number of trailing zeroes in " + num + "! is: " + result);
    }
}