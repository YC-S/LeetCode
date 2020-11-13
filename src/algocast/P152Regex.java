/*
 * Copyright (c) 2020. Yuanchen
 */

package algocast;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class P152Regex {

    private boolean isEqual(char sc, char pc) {
        return sc == pc || pc == '.';
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length(), n = p.length();
        boolean[][] d = new boolean[m + 1][n + 1];
        d[0][0] = true;
        for (int i = 1; i <= m; i++) {
            d[i][0] = false;
        }
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                d[0][j] = d[0][j - 2];
            } else {
                d[0][j] = false;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);
                if (isEqual(sc, pc)) {
                    d[i][j] = d[i - 1][j - 1];
                } else if (pc == '*') {
                    char preChar = p.charAt(j - 2);
                    if (isEqual(sc, preChar)) {
                        d[i][j] = d[i][j - 2] || d[i][j - 1] || d[i - 1][j];
                    } else {
                        d[i][j] = d[i][j - 2];
                    }
                } else {
                    d[i][j] = false;
                }
            }
        }
        return d[m][n];
    }
}
