package laicode.dpIV;

import java.util.Arrays;
import java.util.HashMap;

public class CountAscendingSubsequence {
  final int N = 10000;

  // Segment tree array
  int[] seg = new int[3 * N];

  // Driver code
  public static void main(String[] args) {
    int[] arr = {24};
    System.out.print(new CountAscendingSubsequence().numIncreasingSubsequences(arr));
  }

  // Function for point update in segment tree
  int update(int in, int l, int r, int up_in, int val) {
    // Base case
    if (r < up_in || l > up_in) return seg[in];

    // If l==r==up
    if (l == up_in && r == up_in) return seg[in] = val;

    // Mid element
    int m = (l + r) / 2;

    // Updating the segment tree
    return seg[in] =
        update(2 * in + 1, l, m, up_in, val) + update(2 * in + 2, m + 1, r, up_in, val);
  }

  // Function for the range sum-query
  int query(int in, int l, int r, int l1, int r1) {
    // Base case
    if (l > r) return 0;
    if (r < l1 || l > r1) return 0;
    if (l1 <= l && r <= r1) return seg[in];

    // Mid element
    int m = (l + r) / 2;

    // Calling for the left and the right subtree
    return query(2 * in + 1, l, m, l1, r1) + query(2 * in + 2, m + 1, r, l1, r1);
  }

  // Function to return the count
  public int numIncreasingSubsequences(int[] a) {
    int n = a.length;
    // Copying array arr to sort it
    int[] brr = new int[n];
    System.arraycopy(a, 0, brr, 0, n);

    // Sorting array brr
    Arrays.sort(brr);

    // Map to store the rank of each element
    HashMap<Integer, Integer> r = new HashMap<>();
    for (int i = 0; i < n; i++) r.put(brr[i], i + 1);

    // dp array
    int[] dp = new int[n];

    // To store the final answer
    int ans = 0;

    // Updating the dp array
    for (int i = n - 1; i >= 0; i--) {

      // Rank of the element
      int rank = r.get(a[i]);

      // Solving the dp-states using segment tree
      dp[i] = 1 + query(0, 0, n - 1, rank, n - 1);

      // Updating the final answer
      ans += dp[i];

      // Updating the segment tree
      update(0, 0, n - 1, rank - 1, dp[i] + query(0, 0, n - 1, rank - 1, rank - 1));
    }

    // Returning the final answer
    return ans;
  }
}
