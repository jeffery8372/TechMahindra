import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinMaxUsingStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 5, 40, 30, 50);

        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);

        System.out.println("Maximum Value: " + max.orElse(null));
        System.out.println("Minimum Value: " + min.orElse(null));
    }
}
