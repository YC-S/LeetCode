/*
 * Copyright (c) 2020. Yuanchen
 */

package lunch;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/10/01
 */
public class Q1 {

    // String input = "HG[3|b[2|CA]]F"
    // String output = "HGbCACAbCACAbCACAF"

    private static void helper(char[] array, int i, int n, StringBuilder sb) {
        while (i++ < n) {
            if (array[i] != '[' && array[i] != ']' && array[i] != '|') {
                sb.append(array[i]);
            } else {

            }
        }
    }

    public String change(String input) {
        char[] array = input.toCharArray();
        int n = array.length;
        StringBuilder sb = new StringBuilder();
        helper(array, 0, n, sb);
        return sb.toString();
    }

}
