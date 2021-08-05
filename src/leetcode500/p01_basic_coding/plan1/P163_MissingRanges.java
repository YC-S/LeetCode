package leetcode500.p01_basic_coding.plan1;

import java.util.ArrayList;
import java.util.List;

public class P163_MissingRanges {
  public void findRange(long x, long y, List<String> res) {
    if (y - x > 1) {
      if (y - x == 2) {
        res.add(String.valueOf(y - 1));
      } else {
        res.add((x + 1) + "->" + (y - 1));
      }
    }
  }

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      findRange((long) lower - 1, (long) upper + 1, res);
      return res;
    }
    findRange((long) lower - 1, nums[0], res);
    for (int i = 1; i < nums.length; i++) {
      findRange(nums[i - 1], nums[i], res);
    }
    findRange(nums[nums.length - 1], (long) upper + 1, res);
    return res;
  }
}
