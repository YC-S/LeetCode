package leetcode500.p03_array.plan5;

import java.util.HashSet;
import java.util.Set;

public class P548_SplitArrayWithEqualSum {
  public boolean splitArray(int[] nums) {
    if (nums.length < 7) return false;
    int[] sum = new int[nums.length];
    sum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      sum[i] = sum[i - 1] + nums[i];
    }
    for (int j = 3; j < nums.length - 3; j++) {
      Set<Integer> set = new HashSet<>();
      for (int i = 1; i < j - 1; i++) {
        if (sum[i - 1] == sum[j - 1] - sum[i]) set.add(sum[i - 1]);
      }
      for (int k = j + 2; k < nums.length - 1; k++) {
        int tmp = sum[k - 1] - sum[j];
        if (sum[nums.length - 1] - sum[k] == tmp && set.contains(tmp)) return true;
      }
    }
    return false;
  }
}
