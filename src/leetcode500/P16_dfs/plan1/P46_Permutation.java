package leetcode500.P16_dfs.plan1;

import java.util.ArrayList;
import java.util.List;

public class P46_Permutation {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    helper(res, 0, nums);
    return res;
  }

  private void helper(List<List<Integer>> res, int index, int[] nums) {
    if (index == nums.length) {
      List<Integer> cur = new ArrayList<>();
      for (int num : nums) cur.add(num);
      res.add(cur);
      return;
    }
    for (int i = index; i < nums.length; i++) {
      swap(nums, i, index);
      helper(res, index + 1, nums);
      swap(nums, i, index);
    }
  }

  private void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}
