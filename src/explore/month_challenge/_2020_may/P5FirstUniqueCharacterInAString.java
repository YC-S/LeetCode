/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_may;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @created 2020/05/05
 * @project LeetCode
 */
public class P5FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
