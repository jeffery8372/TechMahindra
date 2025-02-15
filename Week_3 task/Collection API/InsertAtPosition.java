import java.util.LinkedList;

public class InsertAtPosition {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");

        list.add(1, "Yellow"); // Insert at index 1
        System.out.println("Updated LinkedList: " + list);
    }
}
