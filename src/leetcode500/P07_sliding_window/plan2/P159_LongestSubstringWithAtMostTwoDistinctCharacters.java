package leetcode500.P07_sliding_window.plan2;

import java.util.HashMap;
import java.util.Map;

public class P159_LongestSubstringWithAtMostTwoDistinctCharacters {
  public static int lengthOfLongestSubstringTwoDistinct(String s) {
    int i = 0, j = 0;
    Map<Character, Integer> map = new HashMap<>();
    int diff = 0;
    while (j < s.length()) {
      if (!map.containsKey(s.charAt(j))) {
        if (map.keySet().size() == 2) {
          char last = s.charAt(j - 1);
          for (int k = j - 1; k >= i; k--) {
            if (s.charAt(k) != last) {
              i = k + 1;
              diff = Math.max(diff, j - i + 1);
              map.remove(s.charAt(k));
              map.put(s.charAt(j), 1);
              break;
            }
          }
        } else {
          map.put(s.charAt(j), 1);
          diff = Math.max(diff, j - i + 1);
        }
      } else {
        map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
        diff = Math.max(j - i + 1, diff);
      }
      j++;
    }
    return diff;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
  }
}
