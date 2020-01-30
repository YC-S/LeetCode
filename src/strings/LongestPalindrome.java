package strings;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
  public static int longestPalindrome(String s) {
    if (s == null || s.length() == 0) return 0;
    int count = 0;
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (set.contains(s.charAt(i))) {
        set.remove(s.charAt(i));
        count++;
      } else {
        set.add(s.charAt(i));
      }
    }
    return set.isEmpty() ? count * 2 : count * 2 + 1;
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("abccccdd"));
  }
}
