package contest.leetcode.单周赛._222;

import java.util.Comparator;
import java.util.TreeMap;

public class P1712_WaysToSplitArrayIntoThreeSubarrays {
    public int waysToSplit(int[] nums) {
        int MOD = 1000000007;
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        // transform into a TreeMap {{ presum[i], i }: i}
        TreeMap<Integer[], Integer> tree = new TreeMap<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0].compareTo(o2[0]) != 0) {
                    return o1[0].compareTo(o2[0]);
                } else {
                    return o1[1].compareTo(o2[1]);
                }
            }
        });
        for (int i = 0; i < n + 1; i++) {
            tree.put(new Integer[] { presum[i], i }, i);
        }
        long result = 0;
        for (int i = 0; i < n - 2; i++) {
            // nums[0],...,nums[i] | nums[i+1], nums[i+2], ...
            int leftSum = presum[i + 1];
            int remain = presum[n] - leftSum;
            if (remain < leftSum * 2) {
                break;
            }
            // search first & last in presum[i+2],..., presum[n-1]
            int first = Math.max(i + 2, tree.ceilingEntry(new Integer[] { leftSum * 2, i + 2 }).getValue());
            int last = Math.min(n - 1, tree.floorEntry(new Integer[] { leftSum + remain / 2, n - 1 }).getValue());
            result += Math.max(last - first + 1, 0);
        }
        return (int) (result % MOD);
    }
}
