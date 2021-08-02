package laicode.dpIV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestAscendingSubsequenceII {
  public static int[] longest(int[] a) {
    List<Integer> list = lis(a, a.length);
    int[] res = new int[list.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = list.get(i);
    }
    return res;
  }

  /* lis() returns the length of the longest
  increasing subsequence in arr[] of size n */
  static List<Integer> lis(int[] arr, int n) {
    List<Integer> list = new ArrayList<>();
    int[] lis = new int[n];
    int i, j, max = 0;

    /* Initialize LIS values for all indexes */
    for (i = 0; i < n; i++) lis[i] = 1;

    /* Compute optimized LIS values in
    bottom up manner */
    for (i = 1; i < n; i++)
      for (j = 0; j < i; j++) if (arr[i] > arr[j] && lis[i] < lis[j] + 1) lis[i] = lis[j] + 1;

    /* Pick maximum of all LIS values */
    for (i = 0; i < n; i++)
      if (max < lis[i]) {
        max = lis[i];
        list.add(arr[i]);
      }

    return list;
  }

  // driver program to test above functions
  public static void main(String[] args) {
    int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
    int n = arr.length;
    System.out.println(Arrays.toString(longest(arr)));
  }
}
