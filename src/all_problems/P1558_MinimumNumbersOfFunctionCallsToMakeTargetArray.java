package all_problems;

public class P1558_MinimumNumbersOfFunctionCallsToMakeTargetArray {
    public int minOperations(int[] nums) {
        int res = 0, maxLen = 1;
        for (int a : nums) {
            int bits = 0;
            while (a > 0) {
                res += a & 1;
                bits++;
                a >>= 1;
            }
            maxLen = Math.max(maxLen, bits);
        }
        return res + maxLen - 1;
    }
}
