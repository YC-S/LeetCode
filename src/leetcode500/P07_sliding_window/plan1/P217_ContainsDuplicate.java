package leetcode500.P07_sliding_window.plan1;

import java.util.HashSet;
import java.util.Set;

public class P217_ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) {
        return true;
      } else {
        set.add(num);
      }
    }
    return false;
  }
}
