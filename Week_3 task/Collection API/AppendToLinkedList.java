import java.util.LinkedList;

public class AppendToLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        
        list.addLast("Blue"); // Append at end
        System.out.println("Updated LinkedList: " + list);
    }
}
