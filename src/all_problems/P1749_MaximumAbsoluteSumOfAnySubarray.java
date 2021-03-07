package all_problems;

public class P1749_MaximumAbsoluteSumOfAnySubarray {
    public int maxAbsoluteSum(int[] nums) {
        int s = 0, min = 0, max = 0;
        for (int a : nums) {
            s += a;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return max - min;
    }
}
