package leetcode500.p03_array.plan1;

import java.util.Arrays;

public class P532_KDiffPairsInAnArray {
  public int findPairs(int[] nums, int k) {
    Arrays.sort(nums);
    int left = 0, right = 1;
    int count = 0;
    while (left < nums.length && right < nums.length) {
      if (left == right || nums[right] - nums[left] < k) {
        // List item 1 in the text
        right++;
      } else if (nums[right] - nums[left] > k) {
        // List item 2 in the text
        left++;
      } else {
        // List item 3 in the text
        left++;
        count++;
        while (left < nums.length && nums[left] == nums[left - 1]) left++;
      }
    }
    return count;
  }
}
