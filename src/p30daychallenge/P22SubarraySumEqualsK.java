/*
 * Copyright (c) 2020. Yuanchen
 */

package p30daychallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 */
public class P22SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
