/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P493_ReversePairs {

    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int res = 0;
        res += mergeSort(nums, left, mid);
        res += mergeSort(nums, mid + 1, right);
        res += merge(nums, left, mid, right);
        return res;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int count = 0;
        int[] a = new int[right - left + 1];
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if ((long) nums[i] > 2 * (long) nums[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }
        i = left;
        j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                a[index++] = nums[j++];
            } else {
                a[index++] = nums[i++];
            }
        }

        while (i <= mid) {
            a[index++] = nums[i++];
        }
        while (j <= right) {
            a[index++] = nums[j++];
        }

        System.arraycopy(a, 0, nums, left, right - left + 1);
        return count;

    }
}
