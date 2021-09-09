package leetcode500.p03_array.plan1;

import java.util.Arrays;

public class P611_ValidTriangleNumber {
  public static int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int count = 0, n = nums.length;
    for (int i = n - 1; i >= 2; i--) {
      int l = 0, r = i - 1;
      while (l < r) {
        if (nums[l] + nums[r] > nums[i]) {
          count += r - l;
          r--;
        } else l++;
      }
    }
    return count;
  }
}
