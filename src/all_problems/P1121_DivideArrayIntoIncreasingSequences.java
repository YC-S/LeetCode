package all_problems;

public class P1121_DivideArrayIntoIncreasingSequences {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        int cur = 1, groups = 1, n = nums.length;
        for (int i = 1; i < n; ++i) {
            cur = nums[i - 1] < nums[i] ? 1 : cur + 1;
            groups = Math.max(groups, cur);
        }
        return n >= K * groups;
    }
}
