/*
 * Copyright (c) 2020. Yuanchen
 */

package company.google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/23
 */
public class RemoveOuterParentheses {

    public static String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        Deque<Character> dq = new ArrayDeque<>();
        dq.offerLast(S.charAt(0));
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int start = 0;
        while (i < S.length()) {
            if (dq.isEmpty()) {
                dq.offerLast(S.charAt(i));
            } else if (dq.peekLast() == '(' && S.charAt(i) == ')') {
                dq.pollLast();
                if (dq.isEmpty()) {
                    sb.append(S, start + 1, i);
                    start = i + 1;
                }
            } else {
                dq.offerLast(S.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("()()"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }

}
