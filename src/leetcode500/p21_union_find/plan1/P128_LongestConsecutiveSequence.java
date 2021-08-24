package leetcode500.p21_union_find.plan1;

import java.util.HashSet;
import java.util.Set;

public class P128_LongestConsecutiveSequence {
  public int longestConsecutive(int[] num) {
    int max = 0;

    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < num.length; i++) {
      set.add(num[i]);
    }

    for (int i = 0; i < num.length; i++) {
      int count = 1;

      // look left
      int next = num[i];
      while (set.contains(--next)) {
        count++;
        set.remove(next);
      }

      // look right
      next = num[i];
      while (set.contains(++next)) {
        count++;
        set.remove(next);
      }

      max = Math.max(max, count);
    }

    return max;
  }
}
