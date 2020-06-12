/*
 * Copyright (c) 2020. Yuanchen
 */

package june_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/11
 */
public class P11SortColors {

  public void sortColors(int[] nums) {
    int i = 0, j = 0, k = nums.length - 1;
    while (j <= k) {
      if (nums[j] == 0) {
        swap(nums, i++, j++);
      } else if (nums[j] == 1) {
        j++;
      } else {
        swap(nums, j, k--);
      }
    }
  }

  private void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}
