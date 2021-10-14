package leetcode500.p03_array.plan5;

import java.util.HashMap;
import java.util.Map;

public class P525_ContiguousArray {
  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int max = 0, count = 0;
    for (int i = 0; i < nums.length; i++) {
      count = count + (nums[i] == 1 ? 1 : -1);
      if (map.containsKey(count)) {
        max = Math.max(max, i - map.get(count));
      } else {
        map.put(count, i);
      }
    }
    return max;
  }
}
