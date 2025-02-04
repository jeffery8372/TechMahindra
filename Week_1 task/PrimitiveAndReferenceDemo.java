public class PrimitiveAndReferenceDemo {

    // Method that modifies the integer and the array
    public static void modifyValues(int num, int[] arr) {
        // Modifying the integer (passed by value)
        num = 50;

        // Modifying the array (passed by reference)
        arr[0] = 100;
    }

    public static void main(String[] args) {
        // Primitive variable (passed by value)
        int number = 10;

        // Reference variable (array passed by reference)
        int[] array = {1, 2, 3};

        // Printing initial values
        System.out.println("Before method call:");
        System.out.println("Number: " + number);  // 10
        System.out.println("Array: " + array[0] + ", " + array[1] + ", " + array[2]);  // 1, 2, 3

        // Calling the method that modifies the values
        modifyValues(number, array);

        // Printing values after method call
        System.out.println("\nAfter method call:");
        System.out.println("Number: " + number);  // 10 (No change because it was passed by value)
        System.out.println("Array: " + array[0] + ", " + array[1] + ", " + array[2]);  // 100, 2, 3 (Array modified)
        }
}