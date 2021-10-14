package leetcode500.p03_array.plan5;

import java.util.HashMap;
import java.util.Map;

public class P974_SubarraySumsDivisibleByK {
  public int subarraysDivByK(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int prefix = 0, res = 0;
    map.put(0, 1);
    for (int num : nums) {
      prefix = (prefix + num % k + k) % k;
      res += map.getOrDefault(prefix, 0);
      map.put(prefix, map.getOrDefault(prefix, 0) + 1);
    }
    return res;
  }
}
