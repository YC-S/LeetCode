package month_challenge._2021_january.week1;

import java.util.HashMap;
import java.util.Map;

public class Day1PalindromePermutation {
    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int countOdd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                countOdd++;
            }
        }
        return countOdd <= 1;
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("AaBb//a"));
    }
}
