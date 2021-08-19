package leetcode500.P16_dfs.plan1;

import java.util.ArrayList;
import java.util.List;

public class P78_Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    helper(nums, res, 0, cur);
    return res;
  }

  private void helper(int[] nums, List<List<Integer>> res, int index, List<Integer> cur) {
    if (index == nums.length) {
      res.add(new ArrayList<>(cur));
      return;
    }
    cur.add(nums[index]);
    helper(nums, res, index + 1, cur);
    cur.remove(cur.size() - 1);

    helper(nums, res, index + 1, cur);
  }
}
