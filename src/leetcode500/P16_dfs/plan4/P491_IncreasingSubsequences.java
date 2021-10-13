package leetcode500.P16_dfs.plan4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P491_IncreasingSubsequences {
  public List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums.length <= 1) return res;
    List<Integer> cur = new ArrayList<>();
    dfs(nums, cur, res, 0);
    return res;
  }

  private void dfs(int[] nums, List<Integer> cur, List<List<Integer>> res, int index) {
    if (cur.size() >= 2) res.add(new ArrayList<>(cur));
    Set<Integer> used = new HashSet<>();
    for (int i = index; i < nums.length; i++) {
      if (used.contains(nums[i])) continue;
      if (cur.size() == 0 || nums[i] >= cur.get(cur.size() - 1)) {
        cur.add(nums[i]);
        used.add(nums[i]);
        dfs(nums, cur, res, i + 1);
        cur.remove(cur.size() - 1);
      }
    }
  }
}
