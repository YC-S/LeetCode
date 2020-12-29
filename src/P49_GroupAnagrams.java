/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.*;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class P49_GroupAnagrams {

    // Input: strs = ["eat","tea","tan","ate","nat","bat"]
    // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        String[] strs = {"bdddddddddd", "bbbbbbbbbbc"};
        System.out.println(groupAnagrams(strs));
    }
}
