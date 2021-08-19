package leetcode500.P16_dfs.plan1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P47_PermutationII {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) return res;
    helper(res, nums, 0);
    return res;
  }

  private void helper(List<List<Integer>> res, int[] nums, int index) {
    if (index == nums.length) {
      List<Integer> cur = new ArrayList<>();
      for (int num : nums) cur.add(num);
      res.add(cur);
      return;
    }
    Set<Integer> appeared = new HashSet<>();
    for (int i = index; i < nums.length; i++) {
      if (appeared.add(nums[i])) {
        swap(nums, index, i);
        helper(res, nums, index + 1);
        swap(nums, index, i);
      }
    }
  }

  private void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }
}
