
import java.util.*;

public class AnagramFinder {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        // Frequency array for characters in p
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Sliding window for the string s
        int[] sCount = new int[26];
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Update the count for the current character
            sCount[s.charAt(right) - 'a']++;

            // If the window size exceeds the length of p, shrink it
            if (right - left + 1 > p.length()) {
                sCount[s.charAt(left) - 'a']--;
                left++;
            }

            // If the counts match, we found an anagram
            if (Arrays.equals(pCount, sCount)) {
                result.add(left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        AnagramFinder finder = new AnagramFinder();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = finder.findAnagrams(s, p);
        System.out.println("Anagram start indices: " + result);
    }
}
