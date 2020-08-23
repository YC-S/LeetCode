/*
 * Copyright (c) 2020. Yuanchen
 */

package arrays_101;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/22
 */
public class SquaresOfASortedArray {

  public static int[] sortedSquares(int[] A) {
    if (A == null || A.length == 0) {
      return A;
    }
    for (int i = 0; i < A.length; i++) {
      A[i] = Math.abs(A[i]);
    }
    Arrays.sort(A);
    for (int i = 0; i < A.length; i++) {
      A[i] = A[i] * A[i];
    }
    return A;

  }

  public static void main(String[] args) {
    int[] array1 = {-4, -1, 0, 3, 10};
    int[] array2 = {-7, -3, 2, 3, 11};
    System.out.println(Arrays.toString(sortedSquares(array1)));
    System.out.println(Arrays.toString(sortedSquares(array2)));
  }
}
