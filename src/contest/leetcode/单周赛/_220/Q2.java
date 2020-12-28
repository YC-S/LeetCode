/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.leetcode.单周赛._220;

import java.util.HashSet;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/19
 */
public class Q2 {

    public static int maximumUniqueSubarray(int[] nums) {
        int result = 0;
        int currentSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            // increment start until subarray has unique elements
            while (set.contains(nums[end])) {
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            currentSum += nums[end];
            set.add(nums[end]);
            // update result with maximum sum found so far
            result = Math.max(result, currentSum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 5, 6};
        int[] nums2 = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        int[] nums3 = {10000, 1, 10000, 1, 1, 1, 1, 1, 1};
        int[] nums4 = {187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275, 133, 666, 345, 411, 459, 490, 266, 987,
            965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585, 970, 306, 42, 189, 169, 743, 78, 810, 70,
            382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893, 817, 971, 458, 409, 886, 434};
        System.out.println(maximumUniqueSubarray(nums));
        System.out.println(maximumUniqueSubarray(nums2));
        System.out.println(maximumUniqueSubarray(nums3));
        System.out.println(maximumUniqueSubarray(nums4));
    }

}
