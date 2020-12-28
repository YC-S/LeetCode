package contest.leetcode.双周赛._b_41;

import java.util.Arrays;

public class StoneGameVI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] sums = new int[n][3];
        for (int i = 0; i < n; i++) {
            sums[i] = new int[]{aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i]};
        }
        Arrays.sort(sums, (a, b) -> {
            return b[0] - a[0];
        });
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a += sums[i][1];
            } else {
                b += sums[i][2];
            }
        }
        return Integer.compare(a, b);
    }
}
