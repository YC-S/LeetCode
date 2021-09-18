package leetcode500.P16_dfs.plan2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39_CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates); // sort candidates to try them in asc order
    List<List<List<Integer>>> dp = new ArrayList<>();
    for (int i = 1; i <= target; i++) { // run through all targets from 1 to t
      List<List<Integer>> newList = new ArrayList<>(); // combs for curr i
      // run through all candidates <= i
      for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
        // special case when curr target is equal to curr candidate
        if (i == candidates[j]) newList.add(Arrays.asList(candidates[j]));
        // if current candidate is less than the target use prev results
        else
          for (List<Integer> l : dp.get(i - candidates[j] - 1)) {
            if (candidates[j] <= l.get(0)) {
              List<Integer> cl = new ArrayList<>();
              cl.add(candidates[j]);
              cl.addAll(l);
              newList.add(cl);
            }
          }
      }
      dp.add(newList);
    }
    return dp.get(target - 1);
  }
}
