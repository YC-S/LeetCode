package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P79_WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] b, int i, int j, String word, int index) {
        if (i < 0 || i >= b.length || j < 0 || j >= b[i].length || word.charAt(index) != b[i][j]) {
            return false;
        }
        if (word.length() == index + 1) {
            return true;
        }
        b[i][j] = '.';
        boolean res = helper(b, i + 1, j, word, index + 1)
            || helper(b, i - 1, j, word, index + 1)
            || helper(b, i, j + 1, word, index + 1)
            || helper(b, i, j - 1, word, index + 1);
        b[i][j] = word.charAt(index);
        return res;
    }
}
