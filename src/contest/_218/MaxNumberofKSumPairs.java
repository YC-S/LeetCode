/*
 * Copyright (c) 2020. Yuanchen
 */

package contest._218;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/05
 */
public class MaxNumberofKSumPairs {

    public static int Operations(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                count++;
                i++;
                j--;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else if (nums[i] + nums[j] < k) {
                i++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] nums1 = {3, 1, 3, 4, 3};
        System.out.println(Operations(nums, 5));
        System.out.println(Operations(nums1, 6));
    }

}
