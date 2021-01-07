package all_problems;

import java.util.Arrays;

public class P1708_LargestSubarrayLengthK {
    public static int[] largestSubarray(int[] nums, int k) {
        int[] ans = new int[k];
        int max = 0;
        int index = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = nums[i + index];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 2, 3};
        System.out.println(Arrays.toString(largestSubarray(nums, 3)));
    }
}
