/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.top100;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/08
 */
public class P448FindAllNumbersDisappearedInAnArray {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    // Iterate over each of the elements in the original data_structures.array
    for (int i = 0; i < nums.length; i++) {

      // Treat the value as the new index
      int newIndex = Math.abs(nums[i]) - 1;

      // Check the magnitude of value at this new index
      // If the magnitude is positive, make it negative
      // thus indicating that the number nums[i] has
      // appeared or has been visited.
      if (nums[newIndex] > 0) {
        nums[newIndex] *= -1;
      }
    }

    // Response data_structures.array that would contain the missing numbers
    List<Integer> result = new LinkedList<>();

    // Iterate over the numbers from 1 to N and add all those
    // that have positive magnitude in the data_structures.array
    for (int i = 1; i <= nums.length; i++) {

      if (nums[i - 1] > 0) {
        result.add(i);
      }
    }

    return result;
  }
}
