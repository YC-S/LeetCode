package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.Map;
import java.util.TreeMap;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/11
 */
public class P1296_DivideArrayInSetsOfKConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                for (int i = k - 1; i >= 0; --i) {
                    if (map.getOrDefault(key + i, 0) < map.get(key)) {
                        return false;
                    }
                    map.put(key + i, map.get(key + i) - map.get(key));
                }
            }
        }
        return true;
    }
}
