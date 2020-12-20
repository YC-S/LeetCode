/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/08
 */
public class P88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = Arrays.copyOf(nums1, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums3[i] < nums2[j]) {
                nums1[k++] = nums3[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[k++] = nums3[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        }

    }
}
