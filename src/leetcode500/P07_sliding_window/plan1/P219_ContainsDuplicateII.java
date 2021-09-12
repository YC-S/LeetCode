package leetcode500.P07_sliding_window.plan1;

import java.util.HashSet;
import java.util.Set;

public class P219_ContainsDuplicateII {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
      if (set.contains(nums[i])) return true;
      set.add(nums[i]);
      if (set.size() > k) {
        set.remove(nums[i - k]);
      }
    }
    return false;
  }
}
