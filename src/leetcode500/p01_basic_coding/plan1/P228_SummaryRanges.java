package leetcode500.p01_basic_coding.plan1;

import java.util.ArrayList;
import java.util.List;

public class P228_SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int a = nums[i];
      while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) i++;
      if (a == nums[i]) {
        res.add(String.valueOf(a));
      } else {
        res.add(a + "->" + nums[i]);
      }
    }
    return res;
  }
}
