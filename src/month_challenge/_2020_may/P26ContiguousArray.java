/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_may;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/26
 */
public class P26ContiguousArray {

  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int maxlen = 0, count = 0;
    for (int i = 0; i < nums.length; i++) {
      count = count + (nums[i] == 1 ? 1 : -1);
      if (map.containsKey(count)) {
        maxlen = Math.max(maxlen, i - map.get(count));
      } else {
        map.put(count, i);
      }
    }
    return maxlen;
  }
}
