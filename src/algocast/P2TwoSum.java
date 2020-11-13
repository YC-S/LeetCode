/*
 * Copyright (c) 2020. Yuanchen
 */

package algocast;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class P2TwoSum {

    public int[] getTwoNumSumToGivenValue(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int numNeeded = target - nums[i];
            if (map.containsKey(numNeeded)) {
                return new int[]{map.get(numNeeded), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
