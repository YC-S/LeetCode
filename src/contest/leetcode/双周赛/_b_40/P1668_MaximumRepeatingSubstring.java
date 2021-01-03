/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.leetcode.双周赛._b_40;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/29
 */
public class P1668_MaximumRepeatingSubstring {

    public static int maxRepeating(String sequence, String word) {
        int max = 0, cur = 0;
        int w = word.length();
        int is = 0;
        while (is <= sequence.length() - w) {
            if (sequence.substring(is, is + w).equals(word)) {
                cur++;
                max = Math.max(max, cur);
                is += w;
            } else {
                cur = 0;
                is++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc", "ab"));
        System.out.println(maxRepeating("a", "a"));
    }

}
