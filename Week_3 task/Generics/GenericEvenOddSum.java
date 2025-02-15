import java.util.List;

public class GenericEvenOddSum {
    public static <T> void sumEvenOdd(List<T> numbers) {
        int evenSum = 0, oddSum = 0;

        for (int i=0;i<numbers.size();i++) {
            if ((int)(numbers.get(i)) % 2 == 0) {
                evenSum += (int)numbers.get(i);
            } else {
                oddSum +=(int) numbers.get(i);
            }
        }

        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Sum of odd numbers: " + oddSum);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        sumEvenOdd(nums);
    }
}
