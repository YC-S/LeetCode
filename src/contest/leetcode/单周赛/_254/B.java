package contest.leetcode.单周赛._254;

import java.util.Arrays;

public class B {
  public static int[] rearrangeArray(int[] nums) {
    for (int i = 1; i < nums.length - 1; i++) {
      if (nums[i - 1] + nums[i + 1] == nums[i] * 2) {
        swap(nums, i, i + 1);
      }
    }
    for (int i = 1; i < nums.length - 1; i++) {
      if (nums[i - 1] + nums[i + 1] == nums[i] * 2) {
        swap(nums, i, i - 1);
      }
    }

    return nums;
  }

  private static void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6};
    int[] nums1 = {6, 2, 0, 9, 7};
    System.out.println(Arrays.toString(rearrangeArray(nums)));
    System.out.println(Arrays.toString(rearrangeArray(nums1)));
  }
}
