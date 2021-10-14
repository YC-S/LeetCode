package leetcode500.p03_array.plan5;

import java.util.HashMap;
import java.util.Map;

public class P325_MaximumSizeSubarraySumEqualsK {
  public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxLen = 0;
    int currSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currSum += nums[i];
      int currLen = i + 1;
      if (currSum == k) maxLen = currLen;
      else {
        int diff = currSum - k;
        if (map.containsKey(diff)) {
          maxLen = Math.max(maxLen, currLen - map.get(diff));
        }
      }
      // don't update currSum's length since we want the length of c to be the shorstest, to
      // maximize the length of b
      map.putIfAbsent(currSum, currLen);
    }
    return maxLen;
  }
}
