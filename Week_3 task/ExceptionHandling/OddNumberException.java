public class OddNumberException extends Exception {
    public OddNumberException(String message) {
        super(message);
    }
}

public class CheckEvenNumber {
    public static void checkEven(int num) throws OddNumberException {
        if (num % 2 != 0) {
            throw new OddNumberException("The number is odd: " + num);
        } else {
            System.out.println("The number is even: " + num);
        }
    }

    public static void main(String[] args) {
        try {
            checkEven(7); // Change to test different numbers
        } catch (OddNumberException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
