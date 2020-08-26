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
public class ReplaceElementsWithGreatestElementOnRightSide {

  public static int[] replaceElements(int[] arr) {
    if (arr == null || arr.length == 0) {
      return arr;
    }
    if (arr.length == 1) {
      return new int[]{-1};
    }
    int lastIndex = arr.length - 1;
    int max = arr[lastIndex];
    arr[lastIndex] = -1;
    for (int i = arr.length - 2; i >= 0; i--) {
      int tmp = arr[i];
      arr[i] = max;
      max = Math.max(tmp, max);
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] arr = {17, 18, 5, 4, 6, 1};
    System.out.println(Arrays.toString(replaceElements(arr)));
  }
}
