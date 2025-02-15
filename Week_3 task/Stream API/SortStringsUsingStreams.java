import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortStringsUsingStreams {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "cherry", "apricot");

        List<String> ascending = words.stream()
                                      .sorted()
                                      .collect(Collectors.toList());

        List<String> descending = words.stream()
                                       .sorted((s1, s2) -> s2.compareTo(s1))
                                       .collect(Collectors.toList());

        System.out.println("Ascending Order: " + ascending);
        System.out.println("Descending Order: " + descending);
    }
}
