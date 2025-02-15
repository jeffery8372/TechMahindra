import java.util.Collections;
import java.util.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");

        Collections.reverse(list);
        System.out.println("Reversed LinkedList: " + list);
    }
}
