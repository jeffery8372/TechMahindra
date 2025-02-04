// Class representing a User with name and age attributes
class User{
    private String name;
    private int age;

    // Constructor to initialize User object
    public User(String name,int age){
        this.name = name;
        this.age = age;
    }

    // Overriding toString() to provide a readable representation of User objects
    @Override
    public String toString()
    {
        return "User{name='"+name+"', age="+age+"}";
    }

    // Overriding hashCode() to generate a hash based on name and age
    @Override
    public int hashCode()
    {
        return name.hashCode() + age;
    }
    // Overriding equals() to compare two User objects based on name and age
    @Override
    public boolean equals(Object obj){
        if (this == obj) 
        return true; // Same reference, so they are equal
        if (obj == null || getClass() != obj.getClass()) 
        return false; // Ensure correct type
        User user = (User) obj;
        return age == user.age && name.equals(user.name); // Compare values
    }
}

// Main class to demonstrate object comparison
public class Objectclassdriver{
    public static void main(String[] args){
        // Creating two User objects with the same values
        User u1 = new User("Ram", 25);
        User u2 = new User("Ram", 25);

        // Checking equality using the overridden equals() method
        System.out.println(u1.equals(u2)); // Output: true
    }
}
