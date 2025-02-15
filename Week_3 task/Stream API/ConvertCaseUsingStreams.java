import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertCaseUsingStreams {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        List<String> uppercaseWords = words.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());

        List<String> lowercaseWords = words.stream()
                                           .map(String::toLowerCase)
                                           .collect(Collectors.toList());

        System.out.println("Uppercase: " + uppercaseWords);
        System.out.println("Lowercase: " + lowercaseWords);
    }
}
