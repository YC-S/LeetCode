/*
 * Copyright (c) 2020. Yuanchen
 */

package algocast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class P151PhoneNumber {

    private final String[] mapping = new String[]{
        "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    private void combination(String digits, int idx, String str, List<String> result) {
        if (idx == digits.length()) {
            result.add(str);
            return;
        }
        String chars = mapping[digits.charAt(idx) - '2'];
        for (int i = 0; i < chars.length(); i++) {
            combination(digits, idx + 1, str + chars.charAt(i), result);
        }
    }

    // Time: O(4^n), Space: O(n)
    public List<String> letterCombinationsRecursive(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        combination(digits, 0, "", result);
        return result;
    }

    // Time: O(4^n), Space: O(4^n)
    public List<String> letterCombinationsIterative(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            String chars = mapping[digits.charAt(i) - '2'];
            int size = result.size();
            for (int j = 0; j < size; j++) {
                String str = result.poll();
                for (int k = 0; k < chars.length(); k++) {
                    result.add(str + chars.charAt(k));
                }
            }
        }
        return result;
    }

}
