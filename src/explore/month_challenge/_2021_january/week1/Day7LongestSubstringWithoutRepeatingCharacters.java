package explore.month_challenge._2021_january.week1;

import java.util.HashMap;
import java.util.Map;

public class Day7LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int cur = 0;
        int max = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < array.length) {
            if (!map.containsKey(array[right])) {
                cur++;
            } else {
                int prev = map.get(array[right]);
                for (int i = left; i <= prev; ++i) {
                    map.remove(array[i]);
                }
                left = prev + 1;
                cur = right - left + 1;
            }
            map.put(array[right], right);
            max = Math.max(cur, max);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }
}
