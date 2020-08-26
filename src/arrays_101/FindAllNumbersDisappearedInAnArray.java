/*
 * Copyright (c) 2020. Yuanchen
 */

package arrays_101;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/25
 */
public class FindAllNumbersDisappearedInAnArray {

  public static List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int i = 0;
    while (i < nums.length) {
      if (nums[i] == i + 1) {
        i++;
      } else if (nums[i] != nums[nums[i] - 1]) {
        int temp = nums[i] - 1;
        int tmp = nums[i];
        nums[i] = nums[nums[i] - 1];
        nums[temp] = tmp;
      } else if (nums[i] == nums[nums[i] - 1]) {
        i++;
      }
    }

    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != j + 1) {
        res.add(j + 1);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
    System.out.println(findDisappearedNumbers(nums));
  }


}
