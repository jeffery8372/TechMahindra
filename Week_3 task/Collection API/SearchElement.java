import java.util.ArrayList;

public class SearchElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        System.out.println("Contains 'Green': " + colors.contains("Green"));
        System.out.println("Contains 'Yellow': " + colors.contains("Yellow"));
    }
}
