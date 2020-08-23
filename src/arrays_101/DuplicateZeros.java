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
public class DuplicateZeros {

  public static void duplicateZeros(int[] arr) {
    int len = arr.length;
    if (arr == null || arr.length == 0) {
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        for (int j = len - 2; j >= i; j--) {
          arr[j + 1] = arr[j];
        }
        i++;
      }
    }

  }

  public static void main(String[] args) {
    int[] array = {1, 0, 2, 3, 0, 4, 5, 0};
    duplicateZeros(array);
    System.out.println(Arrays.toString(array));
  }
}
