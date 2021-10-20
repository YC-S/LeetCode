package leetcode500.p03_array.plan6;

public class P41_FirstMissingPositive {
  /**
   * This code takes advantage of two insights: 1. Numbers greater then n can be ignored because the
   * missing integer must be in the range 1..n+1 2. If each cell in the array were to contain
   * positive integers only, we can use the negative of the stored number as a flag to mark
   * something (in this case the flag indicates this index was found in some cell of the array)
   */
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
    // (we can ignore those because if all number are > n then we'll simply return 1)
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = n + 1;
      }
    }
    // note: all number in the array are now positive, and on the range 1..n+1

    // 2. mark each cell appearing in the array, by converting the index for that number to negative
    //  once all numbers are made positive, if any number is found in range [1,N], then attach -ve
    // sign to the corresponding index. So for 1, 0th element becomes -ve, for 2 it is 1st
    // considering 0 based index.
    for (int i = 0; i < n; i++) {
      int num = Math.abs(nums[i]);
      if (num > n) {
        continue;
      }
      num--; // -1 for zero index based array (so the number 1 will be at pos 0)
      if (nums[num] > 0) { // prevents double negative operations
        nums[num] = -1 * nums[num];
      }
    }

    // 3. find the first cell which isn't negative (doesn't appear in the array)
    for (int i = 0; i < n; i++) {
      if (nums[i] >= 0) {
        return i + 1;
      }
    }

    // 4. no positive numbers were found, which means the array contains all numbers 1..n
    return n + 1;
  }
}
