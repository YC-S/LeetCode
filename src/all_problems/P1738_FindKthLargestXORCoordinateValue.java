package all_problems;

import java.util.PriorityQueue;

public class P1738_FindKthLargestXORCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int M = matrix.length, N = matrix[0].length;
        int[][] dp = new int[M][N];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {

                int x = (i - 1 < 0 ? 0 : dp[i - 1][j]);
                int y = (j - 1 < 0 ? 0 : dp[i][j - 1]);
                int z = (i - 1 < 0 || j - 1 < 0 ? 0 : dp[i - 1][j - 1]);

                dp[i][j] = (x ^ y ^ z ^ matrix[i][j]);

                pq.add(dp[i][j]);
                if (pq.size() > k) pq.poll();
            }
        }

        return pq.poll();
    }
}
