package contest.leetcode.单周赛._221;

public class Q3 {
    public int[] findBall(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = dfs(mat, 0, i);
        }
        return res;
    }

    private int dfs(int[][] mat, int r, int c) {
        if (r == mat.length)
            return c;

        if (mat[r][c] == 1) {
            if (c == mat[0].length - 1 || mat[r][c + 1] == -1)
                return -1;
            else {
                return dfs(mat, r + 1, c + 1);
            }
        } else {
            if (c == 0 || mat[r][c - 1] == 1)
                return -1;
            else {
                return dfs(mat, r + 1, c - 1);
            }
        }
    }
}
