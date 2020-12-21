/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/20
 */
public class P34_FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[]{first(nums, target), last(nums, target)};
        return res;
    }

    private int first(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    private int last(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}
