package array;

// Input: [1,2,3,4,5,6,7] and k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]

import java.util.Arrays;

public class RotateArray {
  public static void rotate(int[] nums, int k) {
    k %= nums.length;
    int n = nums.length;
    int[] tmp = Arrays.copyOfRange(nums, n - k, n);

    if (n - k >= 0)
      System.arraycopy(nums, 0, nums, k, n - k);

    if (k >= 0)
      System.arraycopy(tmp, 0, nums, 0, k);
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
    rotate(nums, 3);
    System.out.println(Arrays.toString(nums));
  }
}
