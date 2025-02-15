import java.util.LinkedList;

public class InsertFirstLast {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Green");
        list.add("Blue");

        list.addFirst("Red"); // Insert at first position
        list.addLast("Yellow"); // Insert at last position

        System.out.println("Updated LinkedList: " + list);
    }
}
