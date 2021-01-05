package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class P17_LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        char[] array = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(res, array, map, 0, sb);
        return res;
    }

    private static void dfs(List<String> res, char[] array, Map<Character, String> map, int index, StringBuilder sb) {
        if (index == array.length) {
            res.add(sb.toString());
            return;
        }
        char[] arr = map.get(array[index]).toCharArray();
        for (char c : arr) {
            dfs(res, array, map, index + 1, sb.append(c));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

}
