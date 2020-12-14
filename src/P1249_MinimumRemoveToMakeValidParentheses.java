/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/11
 */
public class P1249_MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            }
            if (ch == ')') {
                if (open > 0) {
                    open--;
                } else {
                    continue;
                }
            }
            sb.append(ch);
        }
        int i = sb.length() - 1;
        while (open > 0) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                open--;
            }
            i--;
        }
        return sb.toString();
    }
}
