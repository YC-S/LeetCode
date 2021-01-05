/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/06
 */
public class P6FindAllDuplicatesInAnArray {

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> ans = new ArrayList<>();

    Arrays.sort(nums);

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        ans.add(nums[i]);
        i++;        // skip over next element
      }
    }

    return ans;
  }
}
