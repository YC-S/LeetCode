package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/12
 */
public class P72_EditDistance {

    /**
     * f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of
     * word2
     *
     * Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
     *
     * f(i, j) = f(i - 1, j - 1)
     *
     * Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
     *
     * f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
     *
     * f(i, j - 1) represents insert operation f(i - 1, j) represents delete operation f(i - 1, j - 1) represents
     * replace operation
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            cost[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            cost[0][i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    cost[i + 1][j + 1] = cost[i][j];
                } else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }
}
