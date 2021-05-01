package company.apple;

public class FindSmallest {
  public static int solve(int[] A) {
    int ans = A[0];
    for (int i = 1; i < A.length; i++) {
      if (ans > A[i]) {
        ans = A[i];
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(solve(new int[] {-1, 1, -2, 2}));
    System.out.println(solve(new int[] {-1000, -1, 1, -2, 2, -3}));
    System.out.println(solve(new int[] {-1000, -1, 1, -2, 2, -3, 1000}));
  }
}
