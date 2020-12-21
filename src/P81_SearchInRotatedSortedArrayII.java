/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/20
 */
public class P81_SearchInRotatedSortedArrayII {

    // Input: nums = [2,5,6,0,0,1,2], target = 0
    // Output: true

    // Input: nums = [2,5,6,0,0,1,2], target = 3
    // Output: false

    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] < nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int[] nums1 = {2,5,6,0,0,1,2};
        int[] nums2 = {1,1,3,1};
//        System.out.println(search(nums, 0));
//        System.out.println(search(nums, 3));
        System.out.println(search(nums2, 3));
    }
}
