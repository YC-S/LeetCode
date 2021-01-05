/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.arrays_101;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/23
 */
public class MergeSortedArray {

  // Method 1
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if (nums2 == null || nums2.length == 0) {
      return;
    }
    // nums1 pointer
    int i = 0;
    // nums2 pointer
    int j = 0;
    // only count nums1 element
    int l = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j] && l < m) {
        i++;
        l++;
      } else if (nums1[i] >= nums2[j] && l < m) {
        for (int k = m + j - 1; k >= i; k--) {
          nums1[k + 1] = nums1[k];
        }
        nums1[i] = nums2[j];
        i++;
        j++;
      } else if (nums1[i] == 0) {
        nums1[m + j] = nums2[j];
        i++;
        j++;
      }
    }
  }

  // Method 2
  public static void merge2(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    int a, b;
    while (i >= 0 || j >= 0) {
      a = i > 0 ? nums1[i] : Integer.MIN_VALUE;
      b = j > 0 ? nums2[j] : Integer.MIN_VALUE;
      nums1[k--] = Math.max(nums1[i], nums2[j]);
      if (a < b) {
        j--;
      } else {
        i--;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int[] nums3 = {1, 0};
    int[] nums4 = {2};
    int[] nums5 = {4, 5, 6, 0, 0, 0};
    int[] nums6 = {1, 2, 3};
    int[] nums7 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
    int[] nums8 = {1, 2, 2};
    merge(nums1, 3, nums2, 3);
    merge(nums3, 1, nums4, 1);
    merge(nums5, 3, nums6, 3);
    merge(nums7, 6, nums8, 3);
    System.out.println(Arrays.toString(nums1));
    System.out.println(Arrays.toString(nums3));
    System.out.println(Arrays.toString(nums5));
    System.out.println(Arrays.toString(nums7));
  }
}
