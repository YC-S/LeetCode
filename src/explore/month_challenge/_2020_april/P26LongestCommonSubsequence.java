/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_april;

/**
 * @author shiyuanchen
 * @created 2020/04/26
 * @project LeetCode
 */
public class P26LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {

        // If text1 doesn't reference the shortest string, swap them.
        if (text2.length() < text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        // The previous column starts with all 0's and like before is 1
        // more than the length of the first word.
        int[] previous = new int[text1.length() + 1];

        // Iterate through each column, starting from the last one.
        for (int col = text2.length() - 1; col >= 0; col--) {
            // Create a new data_structures.array to represent the current column.
            int[] current = new int[text1.length() + 1];
            for (int row = text1.length() - 1; row >= 0; row--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    current[row] = 1 + previous[row + 1];
                } else {
                    current[row] = Math.max(previous[row], current[row + 1]);
                }
            }
            // The current column becomes the previous one.
            previous = current;
        }

        // The original problem's answer is in previous[0]. Return it.
        return previous[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
    }
}
