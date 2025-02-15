import java.util.Arrays;
import java.util.List;

public class CountStringsUsingStreams {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "apricot", "banana", "avocado", "cherry");

        long count = words.stream()
                          .filter(word -> word.startsWith("a"))
                          .count();

        System.out.println("Count of words starting with 'a': " + count);
    }
}
