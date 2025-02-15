import java.util.Arrays;
import java.util.LinkedList;

public class InsertMultipleAtPosition {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Blue");

        list.addAll(1, Arrays.asList("Green", "Yellow")); // Insert multiple at index 1
        System.out.println("Updated LinkedList: " + list);
    }
}
