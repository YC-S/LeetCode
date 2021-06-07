package all_problems;

import java.util.HashSet;
import java.util.Set;

public class P1888_MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {
  public int minFlips(String s) {
    int min = Integer.MAX_VALUE;
    int n = s.length();
    Set<Integer> set = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    int expected = s.charAt(0) - '0';
    int expected2 = 1 - (s.charAt(0) - '0');
    for (int i = 0; i < 2 * n; i++) {
      int tmp = s.charAt(i % n) - '0';
      if (tmp != expected) {
        set.add(i);
      }
      if (tmp != expected2) {
        set2.add(i);
      }
      expected = 1 - expected;
      expected2 = 1 - expected2;
      if (i > n - 1) {
        set.remove(i - n);
        set2.remove(i - n);
      }
      if (i >= n - 1) {
        min = Math.min(set.size(), Math.min(set2.size(), min));
      }
    }
    return min;
  }
}
