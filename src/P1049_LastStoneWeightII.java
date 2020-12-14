/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/11
 */
public class P1049_LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        Set<Integer> set = new HashSet<>();
        set.add(stones[0]);
        set.add(-stones[0]);
        for (int i = 1; i < stones.length; i++) {
            Set<Integer> set2 = new HashSet<>();
            for (int item : set) {
                set2.add(item + stones[i]);
                set2.add(item - stones[i]);
            }
            set = set2;
        }
        int min = Integer.MAX_VALUE;
        for (int item : set) {
            min = Math.min(Math.abs(item), min);
        }
        return min;
    }
}
