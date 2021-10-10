package leetcode500.P07_sliding_window.plan3;

import java.util.HashMap;
import java.util.Map;

public class P659_SplitArrayIntoConsecutiveSubsequences {
  public boolean isPossible(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> prevSequence = new HashMap<>();
    for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
    for (int num : nums) {
      if (map.get(num) == 0) continue;
      else if (prevSequence.getOrDefault(num, 0) > 0) {
        prevSequence.put(num, prevSequence.get(num) - 1);
        prevSequence.put(num + 1, prevSequence.getOrDefault(num + 1, 0) + 1);
      } else if (map.getOrDefault(num + 1, 0) > 0 && map.getOrDefault(num + 2, 0) > 0) {
        map.put(num + 1, map.get(num + 1) - 1);
        map.put(num + 2, map.get(num + 2) - 1);
        prevSequence.put(num + 3, prevSequence.getOrDefault(num + 3, 0) + 1);
      } else return false;
      map.put(num, map.get(num) - 1);
    }
    return true;
  }
}
