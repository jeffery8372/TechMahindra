

// A final class - This class cannot be subclassed
final class FinalClass {
    // A final variable - The value cannot be changed once assigned
    final int finalVariable = 10;

    // A final method - This method cannot be overridden in any subclass
    final void display() {
        System.out.println("This is a final method. Value of finalVariable: " + finalVariable);
    }
}

public class FinalKeywordDemo {

    public static void main(String[] args) {
        // Creating an object of FinalClass
        FinalClass finalObj = new FinalClass();

        // Trying to modify the final variable (will cause a compilation error)
        // finalObj.finalVariable = 20; // Uncommenting this will cause an error because finalVariable is final

        // Calling the final method
        finalObj.display();

        // Attempting to extend FinalClass (will cause a compilation error)
        // Uncommenting the following lines will cause an error as FinalClass cannot be extended
        /*
        class SubClass extends FinalClass {
            void display() {
                System.out.println("Overriding the final method.");
            }
        }
        */
}
}