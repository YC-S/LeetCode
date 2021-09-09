package leetcode500.p03_array.plan1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15_3Sum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) return res;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int target = -nums[i];
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        if (nums[left] + nums[right] == target) {
          while (left < right && nums[left] == nums[left + 1]) left++;
          while (left < right && nums[right] == nums[right - 1]) right--;
          res.add(Arrays.asList(nums[left], nums[right], -target));
          left++;
          right--;
        } else if (nums[left] + nums[right] < target) {
          left++;
        } else {
          right--;
        }
      }
    }
    return res;
  }
}
