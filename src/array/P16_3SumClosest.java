/*
 * Copyright (c) 2020. Yuanchen
 */

package array;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/30
 */
public class P16_3SumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 10000;
        for (int i = 0; i < nums.length - 2; ++i) {
            int left = i + 1, right = nums.length - 1;
            boolean check = false;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum - target > 0) {
                    right--;
                } else if (sum - target < 0) {
                    left++;
                } else {
                    closest = sum;
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(threeSumClosest(nums, 82));
    }
}
