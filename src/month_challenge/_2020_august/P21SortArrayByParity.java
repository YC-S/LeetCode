/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_august;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/21
 */
public class P21SortArrayByParity {

  public int[] sortArrayByParity(int[] A) {
    Integer[] B = new Integer[A.length];
    for (int t = 0; t < A.length; ++t) {
      B[t] = A[t];
    }

    Arrays.sort(B, (a, b) -> Integer.compare(a % 2, b % 2));

    for (int t = 0; t < A.length; ++t) {
      A[t] = B[t];
    }
    return A;

        /* Alternative:
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
  }
}
