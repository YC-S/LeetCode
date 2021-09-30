package leetcode500.P07_sliding_window.plan2;

import java.util.HashSet;
import java.util.Set;

public class P3_LongestSubstringWithoutRepeatingCharacters {
  public static int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int i = 0, j = 0;
    int max = 0;
    while (j < s.length()) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j));
      } else {
        for (int k = i; k < j; k++) {
          if (s.charAt(k) != s.charAt(j)) {
            set.remove(s.charAt(k));
          } else {
            i = k + 1;
            break;
          }
        }
      }
      max = Math.max(max, j - i + 1);
      j++;
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }
}
