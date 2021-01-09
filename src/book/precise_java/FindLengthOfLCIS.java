/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/21
 */
public class FindLengthOfLCIS {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        int[] nums1 = {2, 2, 2, 2, 2};
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(nums));
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(nums1));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int max = 1;
        int cur = 1;
        while (right < nums.length) {
            if (nums[right] > nums[right - 1]) {
                cur++;
                max = Math.max(cur, max);
                right++;
            } else {
                left = right;
                right++;
                cur = 1;
            }
        }
        return max;
    }

}
