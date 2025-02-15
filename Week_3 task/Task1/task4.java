//Task 4 : Use ArrayCopyRange() function to demonstrate and example such that you copy the range of values in an
//array.

import java.util.Arrays;

public class task4 {
        public static void main(String[] args) {
        // Original array
        int[] originalArray = {10, 20, 30, 40, 50, 60, 70, 80};

        // Copy a range from index 2 to 5 (index 5 is exclusive)
        int[] copiedArray = Arrays.copyOfRange(originalArray, 2, 5);

        // Displaying arrays
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Copied Range (index 2 to 5): " + Arrays.toString(copiedArray));
    }
}
