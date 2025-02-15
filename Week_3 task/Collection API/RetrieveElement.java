import java.util.ArrayList;

public class RetrieveElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        System.out.println("Element at index 1: " + colors.get(1));
    }
}
