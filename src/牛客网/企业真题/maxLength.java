/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.企业真题;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/03
 */
public class maxLength {

    public static int maxLength(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int cur = 0, max = 0;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (i < arr.length) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
                cur = map.size();
                max = Math.max(max, cur);
            } else {
                int prevIndex = map.get(arr[i]);
                map.clear();
                for (int j = prevIndex + 1; j <= i; ++j) {
                    map.put(arr[j], j);
                }
                cur = map.size();
                max = Math.max(max, cur);
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {2, 2, 3, 4, 3};
        System.out.println(maxLength(input));
    }
}
