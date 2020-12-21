/*
 * Copyright (c) 2020. Yuanchen
 */

package jzOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/21
 */
public class MoreThanHalf {

    // [1,2,3,2,2,2,5,4,2]
    // 2

    public int MoreThanHalfNum_Solution(int[] array) {
        int n = array.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; ++i) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
