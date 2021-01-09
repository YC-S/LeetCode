/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_july;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/08
 */
public class P83Sum {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new LinkedList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
        while (lo < hi) {
          if (nums[lo] + nums[hi] == sum) {
            res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
            while (lo < hi && nums[lo] == nums[lo + 1]) {
              lo++;
            }
            while (lo < hi && nums[hi] == nums[hi - 1]) {
              hi--;
            }
            lo++;
            hi--;
          } else if (nums[lo] + nums[hi] < sum) {
            lo++;
          } else {
            hi--;
          }
        }
      }
    }
    return res;
  }
}
