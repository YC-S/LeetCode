public class P1685_SumOfAbsoluteDifferencesInASortedArray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length - 1;
        for (int i = 1; i <= len; i++) {
            nums[i] += nums[i - 1];
        }
        int prev = 0;
        for (int i = 0; i <= len; i++) {
            int curr = nums[i] - prev;
            prev = nums[i];
            int lower = ((i + 1) * curr) - nums[i];
            int higher = (nums[len] - nums[i]) - ((len - i) * curr);
            nums[i] = lower + higher;
        }
        return nums;
    }
}
