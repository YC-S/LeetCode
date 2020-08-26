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
public class MoveZeros {

  public static void moveZeros(int[] nums) {
    int i = 0, j = nums.length - 1;
    while (i < j) {
      if (nums[j] == 0) {
        j--;
      } else if (nums[i] == 0) {
        // shift from i + 1 to j
        for (int k = i + 1; k <= j; k++) {
          nums[k - 1] = nums[k];
        }
        nums[j] = 0;
        j--;
      } else if (nums[i] != 0) {
        i++;
      }
    }
  }

  public static void moveZeros2(int[] nums) {
    int i = 0;
    int j = 1;
    while (j < nums.length) {
      if (nums[j] == 0 && nums[i] != 0) {
        i++;
        j++;
      } else if (nums[j] == 0 && nums[i] == 0) {
        j++;
      } else if (nums[j] != 0 && nums[i] == 0) {
        //swap i and j
        swap(nums, i, j);
        i++;
        j++;
      } else if (nums[j] != 0 && nums[i] != 0) {
        i++;
        j++;
      }
    }
  }

  public static void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  public static void main(String[] args) {
//    int[] arr = new int[]{0, 1, 0, 3, 12};
    int[] arr1 = new int[]{1, 0, 1};
    moveZeros2(arr1);
    System.out.println(Arrays.toString(arr1));
  }
}
