/*
 * Copyright (c) 2020. Yuanchen
 */

package jzOffer;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class ReverseSentence {

    public static void main(String[] args) {
        ReverseSentence solution = new ReverseSentence();
        System.out.println(solution.ReverseSentence("student. a am I"));
    }

    public String ReverseSentence(String str) {
        String[] arr = str.split(" ");
        if (arr.length == 0) {
            return "";
        }
        for (int i = 0; i < arr.length / 2; ++i) {
            swap(i, arr.length - 1 - i, arr);
        }
        for (String s : arr) {
            helper(s);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private void swap(int a, int b, String[] arr) {
        String tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private void helper(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length / 2; ++i) {
            swap(i, str.length() - 1 - i, array);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c);
        }
        str = sb.toString();
    }

    private void swap(int a, int b, char[] arr) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
