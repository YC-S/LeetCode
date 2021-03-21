package all_problems;

public class P1800_MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        System.out.println(new P1800_MaximumAscendingSubarraySum().maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        System.out.println(new P1800_MaximumAscendingSubarraySum().maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
        System.out.println(new P1800_MaximumAscendingSubarraySum().maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
        System.out.println(new P1800_MaximumAscendingSubarraySum().maxAscendingSum(new int[]{100, 10, 1}));
    }

    public int maxAscendingSum(int[] nums) {
        int cur = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            max = Math.max(cur, max);
        }
        return max;
    }
}
