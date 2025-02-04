
// Car class encapsulating the properties and behaviors of a car
class Car {
    // Private instance variables
    private String make;
    private String model;
    private int year;

    // Constructor to initialize the car's properties
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getter methods
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    // Setter methods
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Method to simulate starting the engine
    public void startEngine() {
        System.out.println("The engine of the " + make + " " + model + " has started.");
    }
}

// ElectricCar class extending Car, adding battery range functionality
class ElectricCar extends Car {
    // Private instance variable for battery range
    private int batteryRange;

    // Constructor to initialize the electric car's properties
    public ElectricCar(String make, String model, int year, int batteryRange) {
        super(make, model, year); // Call the parent class constructor
        this.batteryRange = batteryRange;
    }

    // Getter method for battery range
    public int getBatteryRange() {
        return batteryRange;
    }

    // Setter method for battery range
    public void setBatteryRange(int batteryRange) {
        this.batteryRange = batteryRange;
    }

    // Method to simulate charging the battery
    public void chargeBattery() {
        System.out.println("The " + getMake() + " " + getModel() + " is being charged. Battery range is " + batteryRange + " miles.");
    }

    // Override the startEngine method to add specific functionality for ElectricCar
    @Override
    public void startEngine() {
        System.out.println("The electric engine of the " + getMake() + " " + getModel() + " has started silently.");
    }
}

// Cardriver class to demonstrate polymorphism
public class Cardriver {
    public static void main(String[] args) {
        // Create Car and ElectricCar objects
        Car car1 = new Car("Toyota", "Camry", 2020);
        ElectricCar electricCar1 = new ElectricCar("Tesla", "Model S", 2022, 370);

        // Create an array of Car objects, containing both Car and ElectricCar objects
        Car[] cars = new Car[2];
        cars[0] = car1;
        cars[1] = electricCar1;

        // Loop through the array and call the startEngine() method on each object
        for (Car car : cars) {
            car.startEngine();  // Polymorphism in action: it will call the appropriate startEngine() method
            }
        }
}
