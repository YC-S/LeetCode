package contest.leetcode.单周赛._256;

import java.util.Arrays;

public class A {
  public static int minimumDifference(int[] nums, int k) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return 0;
    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - k + 1; i++) {
      min = Math.min(min, nums[i + k - 1] - nums[i]);
    }
    return min;
  }

  public static void main(String[] args) {
    System.out.println(minimumDifference(new int[] {9, 4, 1, 7}, 2));
    System.out.println(minimumDifference(new int[] {90}, 1));
    System.out.println(
        minimumDifference(new int[] {87063, 61094, 44530, 21297, 95857, 93551, 9918}, 6));
  }
}
