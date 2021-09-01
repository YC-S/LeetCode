package leetcode500.p30_randomization.plan1;

import java.util.*;

public class P398_RandomPickIndex {
  private final Random random;
  private final Map<Integer, List<Integer>> index;

  public P398_RandomPickIndex(int[] nums) {
    random = new Random();
    index = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      index.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }
  }

  public int pick(int target) {
    List<Integer> list = index.get(target);
    return list.get(random.nextInt(list.size()));
  }
}
