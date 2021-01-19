package all_problems;

import java.util.Arrays;

public class P1039_MinimumScoreTriangulationOfPolygon {
    int[][] memo;

    public int minScoreTriangulation(int[] A) {
        memo = new int[A.length][A.length];
        Arrays.stream(memo).forEach(x -> Arrays.fill(x, -1));
        return triangles(A, 0, A.length - 1);
    }

    private int triangles(int[] A, int lo, int hi) {
        if (hi - lo + 1 < 3) return 0;
        if (memo[lo][hi] >= 0) return memo[lo][hi];
        int ans = Integer.MAX_VALUE;
        for (int i = lo + 1; i < hi; i++) {
            ans = Math.min(ans, A[lo] * A[i] * A[hi] + triangles(A, lo, i) + triangles(A, i, hi));
        }
        memo[lo][hi] = ans;
        return ans;
    }
}
