/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/13
 */
public class P13LargestDivisibleSubset {

  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int[] f = new int[nums.length];
    int[] pre = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      f[i] = 1;
      pre[i] = i;
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0 && f[i] < f[j] + 1) {
          f[i] = f[j] + 1;
          pre[i] = j;
        }
      }
    }

    List<Integer> ans = new ArrayList<Integer>();
    if (nums.length == 0) {
      return ans;
    }
    int max = 0;
    int max_i = 0;
    for (int i = 0; i < nums.length; i++) {
      if (f[i] > max) {
        max = f[i];
        max_i = i;
      }
    }
    ans.add(nums[max_i]);
    while (max_i != pre[max_i]) {
      max_i = pre[max_i];
      ans.add(nums[max_i]);
    }
    Collections.reverse(ans);
    return ans;
  }
}
