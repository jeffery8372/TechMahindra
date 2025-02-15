//Task 3 : Demonstrate with an example with the difference between equals() vs deepEquals() method?
import java.util.Objects;

public class task3{
    public static void main(String[] args) {
        // Simple objects comparison
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        System.out.println("Using equals(): " + Objects.equals(str1, str2));  // true
        System.out.println("Using deepEquals(): " + Objects.deepEquals(str1, str2));  // true

        // 1D Array comparison
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};

        System.out.println("Using equals() on arrays: " + Objects.equals(arr1, arr2)); // false (compares references)
        System.out.println("Using deepEquals() on arrays: " + Objects.deepEquals(arr1, arr2)); // true (compares values)

        // 2D Array comparison
        int[][] deepArr1 = {{1, 2}, {3, 4}};
        int[][] deepArr2 = {{1, 2}, {3, 4}};

        System.out.println("Using equals() on 2D arrays: " + Objects.equals(deepArr1, deepArr2)); // false
        System.out.println("Using deepEquals() on 2D arrays: " + Objects.deepEquals(deepArr1, deepArr2)); // true
    }
}
