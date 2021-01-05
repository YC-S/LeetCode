package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/09
 */
public class P31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int last = nums[nums.length - 1];
        int a = nums.length - 1, b = 0;
        for (int i = nums.length - 2; i >= 0; --i) {
            int cur = nums[i];
            if (cur < last) {
                a = i;
                break;
            } else {
                last = cur;
            }
        }
        if (a == nums.length - 1) {
            reverse(nums);
            return;
        }
        for (int i = nums.length - 1; i > a; --i) {
            int cur = nums[i];
            if (cur > nums[a]) {
                b = i;
                break;
            }
        }
        swap(nums, a, b);
        int left = a + 1, right = nums.length - 1;
        while (left <= right) {
            swap(nums, left++, right--);
        }
        return;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
