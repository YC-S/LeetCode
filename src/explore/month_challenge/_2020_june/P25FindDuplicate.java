/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_june;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/26
 */
public class P25FindDuplicate {

  public int findDuplicate(int[] nums) {
    if (nums.length > 1) {
      int slow = nums[0];
      int fast = nums[nums[0]];
      while (slow != fast) {
        slow = nums[slow];
        fast = nums[nums[fast]];
      }

      fast = 0;
      while (fast != slow) {
        fast = nums[fast];
        slow = nums[slow];
      }
      return slow;
    }
    return -1;
  }
}
