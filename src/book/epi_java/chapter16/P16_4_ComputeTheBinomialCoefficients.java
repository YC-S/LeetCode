package book.epi_java.chapter16;

public class P16_4_ComputeTheBinomialCoefficients {
  public static int computeBinomialCoefficients(int n, int k) {
    return helper(n, k, new int[n + 1][k + 1]);
  }

  private static int helper(int n, int k, int[][] matrix) {
    if (n == k || k == 0) return 1;
    if (matrix[n][k] == 0) {
      int noK = helper(n - 1, k, matrix);
      int withK = helper(n - 1, k - 1, matrix);
      matrix[n][k] = noK + withK;
    }
    return matrix[n][k];
  }

  public static void main(String[] args) {
    System.out.println(computeBinomialCoefficients(5, 2));
  }
}
