import java.util.ArrayList;

public class InsertFirstPosition {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Green");
        colors.add("Blue");

        colors.add(0, "Red"); // Insert at first position
        System.out.println("Updated ArrayList: " + colors);
    }
}
