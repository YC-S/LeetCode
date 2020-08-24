/*
 * Copyright (c) 2020. Yuanchen
 */

package arrays_101;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/24
 */
public class CheckIfExist {

  public static boolean checkIfExist(int[] arr) {
    if (arr == null || arr.length == 0) {
      return false;
    }
    Set<Integer> set = new HashSet<>();
    for (int i : arr) {
      set.add(i * 2);
    }
    int countZero = 0;
    for (int j : arr) {
      if (j == 0) {
        countZero++;
        continue;
      }
      if (set.contains(j)) {
        return true;
      }
    }
    return countZero >= 2;
  }

  public static void main(String[] args) {
//    int[] arr = new int[]{10, 2, 5, 3};
    int[] arr1 = new int[]{-2, 0, 10, -19, 4, 6, -8};
//    System.out.println(checkIfExist(arr));
    System.out.println(checkIfExist(arr1));
  }
}
