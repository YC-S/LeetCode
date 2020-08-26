/*
 * Copyright (c) 2020. Yuanchen
 */

package arrays_101;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/24
 */
public class SortArrayByParity {

  public static int[] sortArrayByParity(int[] A) {
    if (A == null || A.length == 0) {
      return A;
    }
    int i = 0, j = A.length - 1;
    while (i <= j) {
      if (A[i] % 2 == 0) {
        i++;
      } else if (A[j] % 2 == 1) {
        j--;
      } else if (A[i] % 2 == 1 && A[j] % 2 == 0) {
        swap(A, i, j);
        i++;
        j--;
      } else if (A[i] % 2 == 0 && A[j] % 2 == 1) {
        i++;
        j--;
      }
    }
    return A;
  }

  public static void swap(int[] A, int a, int b) {
    int tmp = A[a];
    A[a] = A[b];
    A[b] = tmp;
  }

  public static void main(String[] args) {
    int[] A = {3, 1, 2, 4};
    System.out.println(Arrays.toString(sortArrayByParity(A)));
  }
}
