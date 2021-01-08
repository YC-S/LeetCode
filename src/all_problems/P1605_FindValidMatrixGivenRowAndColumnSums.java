package all_problems;

public class P1605_FindValidMatrixGivenRowAndColumnSums {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] A = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                A[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= A[i][j];
                colSum[j] -= A[i][j];
            }
        }
        return A;
    }
}
