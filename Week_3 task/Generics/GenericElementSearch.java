import java.util.List;

public class GenericElementSearch {
    public static <T> int findFirstOccurrence(List<T> list, T target) {
        return list.indexOf(target);
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry", "banana", "date");
        System.out.println("Index of 'banana': " + findFirstOccurrence(words, "banana")); // 1
        System.out.println("Index of 'grape': " + findFirstOccurrence(words, "grape")); // -1
    }
}
