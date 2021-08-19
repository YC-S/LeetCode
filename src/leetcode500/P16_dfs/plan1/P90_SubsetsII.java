package leetcode500.P16_dfs.plan1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90_SubsetsII {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    helper(res, cur, 0, nums);
    return res;
  }

  private void helper(List<List<Integer>> res, List<Integer> cur, int index, int[] nums) {
    if (index <= nums.length) res.add(new ArrayList<>(cur));
    for (int i = index; i < nums.length; i++) {
      if (i > index && nums[i] == nums[i - 1]) continue;
      cur.add(nums[i]);
      helper(res, cur, i + 1, nums);
      cur.remove(cur.size() - 1);
    }
  }
}
