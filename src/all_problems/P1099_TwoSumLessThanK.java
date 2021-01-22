package all_problems;

import java.util.Arrays;

public class P1099_TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums); // Time cost O(nlogn).
        int max = -1, i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < k) { // find one candidate.
                max = Math.max(max, sum);
                ++i; // increase the smaller element.
            } else { // >= sum.
                --j; // decrease the bigger element.
            }
        }
        return max;
    }
}
