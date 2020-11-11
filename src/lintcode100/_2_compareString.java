/*
 * Copyright (c) 2020. Yuanchen
 */

package lintcode100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/01
 */
public class _2_compareString {

    public boolean compareStrings(String A, String B) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (Character c : a) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }

        }
        for (Character c : b) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                if (map.get(c) == 0) {
                    return false;
                } else {
                    int tmp = map.get(c);
                    map.put(c, tmp - 1);
                }
            }
        }
        return true;
    }
}
