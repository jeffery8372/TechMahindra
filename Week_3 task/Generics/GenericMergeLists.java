import java.util.ArrayList;
import java.util.List;

public class GenericMergeLists {
    public static <T> List<T> mergeListsAlternately(List<T> list1, List<T> list2) {
        List<T> merged = new ArrayList<>();
        int maxSize = Math.max(list1.size(), list2.size());

        for (int i = 0; i < maxSize; i++) {
            if (i < list1.size()) merged.add(list1.get(i));
            if (i < list2.size()) merged.add(list2.get(i));
        }

        return merged;
    }

    public static void main(String[] args) {
        List<String> listA = List.of("A", "B", "C");
        List<String> listB = List.of("1", "2", "3", "4");

        System.out.println("Merged List: " + mergeListsAlternately(listA, listB));
    }
}
