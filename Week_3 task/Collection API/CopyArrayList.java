import java.util.ArrayList;

public class CopyArrayList {
    public static void main(String[] args) {
        ArrayList<String> original = new ArrayList<>();
        original.add("Red");
        original.add("Green");
        original.add("Blue");

        ArrayList<String> copy = new ArrayList<>(original);
        System.out.println("Copied ArrayList: " + copy);
    }
}
