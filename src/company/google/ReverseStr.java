/*
 * Copyright (c) 2020. Yuanchen
 */

package company.google;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/14
 */
public class ReverseStr {

    public static void main(String[] args) {
        ReverseStr solution = new ReverseStr();
        System.out.println(solution.reverseStr("abcd", 4));
    }

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        int left = s.length() % (2 * k);
        int i = 0;
        for (; i < s.length() / (2 * k); ++i) {
            sb.append(reverse(s, i * 2 * k, (i + 1) * (2 * k), array, k));
        }
        if (left <= k) {
            sb.append(reverse(s, s.length() - left));
        }
        if (left > k && left < 2 * k) {
            sb.append(reverse(s, s.length() - left, s.length() - left + k));
        }
        return sb.toString();
    }

    private String reverse(String s, int start, int end, char[] array, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = start + k - 1; i >= start; i--) {
            sb.append(s.charAt(i));
        }
        for (int i = start + k; i < end; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private String reverse(String s, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= start; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private String reverse(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = end - 1; i >= start; i--) {
            sb.append(s.charAt(i));
        }
        for (int i = end; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
