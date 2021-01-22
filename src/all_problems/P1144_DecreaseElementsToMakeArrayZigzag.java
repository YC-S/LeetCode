package all_problems;

public class P1144_DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        int left;
        int right;
        for (int i = 0; i < n; ++i) {
            left = i > 0 ? nums[i - 1] : 1001;
            right = i + 1 < n ? nums[i + 1] : 1001;
            res[i % 2] += Math.max(0, nums[i] - Math.min(left, right) + 1);
        }
        return Math.min(res[0], res[1]);
    }
}
