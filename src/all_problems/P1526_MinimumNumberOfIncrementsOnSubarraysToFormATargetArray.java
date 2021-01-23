package all_problems;

public class P1526_MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {
    public int minNumberOperations(int[] target) {
        int res = 0, pre = 0;
        for (int a : target) {
            res += Math.max(a - pre, 0);
            pre = a;
        }
        return res;
    }
}
