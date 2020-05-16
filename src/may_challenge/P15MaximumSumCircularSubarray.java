/*
 * Copyright (c) 2020. Yuanchen
 */

package may_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/15
 */
public class P15MaximumSumCircularSubarray {

  public static int maxSubarraySumCircular(int[] A) {
    int n = A.length;

    int ans = A[0], cur = A[0];
    for (int i = 1; i < n; ++i) {
      cur = A[i] + Math.max(cur, 0);
      ans = Math.max(ans, cur);
    }

    // ans is the answer for 1-interval subarrays.
    // Now, let's consider all 2-interval subarrays.
    // For each i, we want to know
    // the maximum of sum(A[j:]) with j >= i+2

    // rightsums[i] = A[i] + A[i+1] + ... + A[n-1]
    int[] rightsums = new int[n];
    rightsums[n - 1] = A[n - 1];
    for (int i = n - 2; i >= 0; --i) {
      rightsums[i] = rightsums[i + 1] + A[i];
    }

    // maxright[i] = max_{j >= i} rightsums[j]
    int[] maxright = new int[n];
    maxright[n - 1] = A[n - 1];
    for (int i = n - 2; i >= 0; --i) {
      maxright[i] = Math.max(maxright[i + 1], rightsums[i]);
    }

    int leftsum = 0;
    for (int i = 0; i < n - 2; ++i) {
      leftsum += A[i];
      ans = Math.max(ans, leftsum + maxright[i + 2]);
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
    System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5}));
    System.out.println(maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
    System.out.println(maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
    System.out.println(maxSubarraySumCircular(new int[]{-2, -3, -1}));
  }
}
