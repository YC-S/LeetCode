package all_problems;

public class P885_SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int dx = 0, dy = 1, n = 0, tmp;
        for (int j = 0; j < R * C; ++n) {
            for (int i = 0; i < n / 2 + 1; ++i) {
                if (0 <= r0 && r0 < R && 0 <= c0 && c0 < C)
                    res[j++] = new int[]{r0, c0};
                r0 += dx;
                c0 += dy;
            }
            tmp = dx;
            dx = dy;
            dy = -tmp;
        }
        return res;
    }
}
