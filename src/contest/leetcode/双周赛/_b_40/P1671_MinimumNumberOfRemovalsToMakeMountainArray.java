/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.leetcode.双周赛._b_40;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/29
 */
public class P1671_MinimumNumberOfRemovalsToMakeMountainArray {

    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] left = new int[n]; // maximum increasing subsequence in the left of an element.
        int[] right = new int[n]; // maximum increasing subsequence in the left of an element.
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // calculating maximum increasing subsequence for the left of an index.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && left[i] < left[j] + 1)
                    left[i] = left[j] + 1;
            }
        }

        // calculating maximum increasing subsequence for the right of an index.
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i] && right[i] < right[j] + 1)
                    right[i] = right[j] + 1;
            }
        }

        // calculating the maximum number of elements that can be involved in a mountain array.
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
		   /*
		       If the below conditional statement is not given, then strictly increasing or strictly
			   decreasing sequences will also be considered. It will hence fail in,
			   Test case: [10, 9, 8, 7, 6, 5, 4, 5, 4].
					---Thanks to @chejianchao for suggesting the test case.
				We need to make sure both the LIS on the left and right, ending at index i,
				has length > 1.
		   */
            if (right[i] > 1 && left[i] > 1) // if element nums[i] is a valid peak,
                max = Math.max(max, left[i] + right[i] - 1);
        }

        // we need to delete the rest of the elements.
        return n - max;
    }

    public static void main(String[] args) {
//        System.out.println(minimumMountainRemovals(new int[]{1, 3, 1}));
//        System.out.println(minimumMountainRemovals(new int[]{2, 1, 1, 5, 6, 2, 3, 1}));
//        System.out.println(minimumMountainRemovals(new int[]{4, 3, 2, 1, 1, 2, 3, 1}));
//        System.out.println(minimumMountainRemovals(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
//        System.out.println(minimumMountainRemovals(new int[]{1, 16, 84, 9, 29, 71, 86, 79, 72, 12}));
        System.out.println(minimumMountainRemovals(new int[]{9, 8, 1, 7, 6, 5, 4, 3, 2, 1}));
    }

    public int minimumMountainRemovals1(int[] nums) {
        int n = nums.length;
        int[] left = new int[n]; // maximum increasing subsequence in the left of an element.
        int[] right = new int[n]; // maximum increasing subsequence in the left of an element.
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // calculating maximum increasing subsequence for the left of an index.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && left[i] < left[j] + 1) {
                    left[i] = left[j] + 1;
                }
            }
        }

        // calculating maximum increasing subsequence for the right of an index.
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i] && right[i] < right[j] + 1) {
                    right[i] = right[j] + 1;
                }
            }
        }

        // calculating the maximum number of elements that can be involved in a mountain array.
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
		   /*
		       If the below conditional statement is not given, then strictly increasing or strictly
			   decreasing sequences will also be considered. It will hence fail in,
			   Test case: [10, 9, 8, 7, 6, 5, 4, 5, 4].
					---Thanks to @chejianchao for suggesting the test case.
				We need to make sure both the LIS on the left and right, ending at index i,
				has length > 1.
		   */
            if (right[i] > 1 && left[i] > 1) // if element nums[i] is a valid peak,
            {
                max = Math.max(max, left[i] + right[i] - 1);
            }
        }

        // we need to delete the rest of the elements.
        return n - max;
    }
}
