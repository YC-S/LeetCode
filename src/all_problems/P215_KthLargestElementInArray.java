package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P215_KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left <= right) {
            int p = partition(nums, left, right);
            if (p == nums.length - k)
                return nums[p];
            else if (p > nums.length - k)
                return quickSelect(nums, left, p - 1, k);
            else
                return quickSelect(nums, p + 1, right, k);
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right) {
        int i = left + 1, j = right;
        while (true) {
            while (i <= right && nums[i] < nums[left])
                i++;
            while (j >= left + 1 && nums[j] > nums[left])
                j--;
            if (i > j)
                break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        int temp = nums[left];
        nums[left] = nums[j];
        nums[j] = temp;
        return j;
    }
}
