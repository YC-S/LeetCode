/*
 * Copyright (c) 2020. Yuanchen
 */

package lintcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/01
 */
public class _1_Anagram {

    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sortedStr = new String(temp);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<String>());
            }
            map.get(sortedStr).add(str);
        }

        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                result.addAll(list);
            }
        }

        return result;
    }
}
