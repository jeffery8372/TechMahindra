import java.util.LinkedList;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");

        System.out.println("First occurrence of 'Green': " + list.indexOf("Green"));
        System.out.println("Last occurrence of 'Green': " + list.lastIndexOf("Green"));
    }
}
