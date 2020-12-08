/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/07
 */
public class P53_MaximumSubarray {

//    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//    Output: 6
//    Explanation: [4,-1,2,1] has the largest sum = 6.

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maximum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (curSum < 0) {
                curSum = nums[i];
                maximum = Math.max(maximum, curSum);
            } else {
                curSum += nums[i];
                if (curSum < 0) {
                    curSum = nums[i];
                    maximum = Math.max(maximum, curSum);
                } else {
                    maximum = Math.max(maximum, curSum);
                }
            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1};
        System.out.println(maxSubArray(nums));
    }

}
