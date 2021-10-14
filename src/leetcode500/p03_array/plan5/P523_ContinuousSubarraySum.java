package leetcode500.p03_array.plan5;

import java.util.HashMap;
import java.util.Map;

public class P523_ContinuousSubarraySum {
  public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (k != 0) sum %= k;
      Integer prev = map.get(sum);
      if (prev != null) {
        if (i - prev > 1) return true;
      } else {
        map.put(sum, i);
      }
    }
    return false;
  }
}
