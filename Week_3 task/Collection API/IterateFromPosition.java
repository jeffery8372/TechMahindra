import java.util.LinkedList;

public class IterateFromPosition {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");

        for (int i = 2; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
