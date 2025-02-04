// Abstract class Animal with an abstract method makeSound()
abstract class Animal {
    // Abstract method, which must be implemented by subclasses
    abstract void makeSound();
}

// Concrete subclass Dog that extends Animal
class Dog extends Animal {
    // Implementing the makeSound() method in Dog class
    @Override
    void makeSound() {
        System.out.println("The dog is barking!");
    }
}

public class Animaldriver {
    public static void main(String[] args) {
        // Creating an object of Dog, which is a subclass of Animal
        Animal myDog = new Dog();
        
        // Calling the makeSound() method on the Dog object
        myDog.makeSound();  // Output: The dog is barking!
        }
}