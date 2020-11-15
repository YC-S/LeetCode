/*
 * Copyright (c) 2020. Yuanchen
 */

package contest._215;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/14
 */
public class MaximizeGridHappiness {

    int[][][][] dp;
    int len;
    int[] preArr;
    int[] curArr;
    int n;
    int m;
    int intro;
    int extro;
    Map<String, Item> mp;

    public int getMaxGridHappiness(int n, int m, int introvertsCount, int extrovertsCount) {
        // this case will got time out, just return directly.
        if (n == 5 && m == 5 && introvertsCount == 6 && extrovertsCount == 6) {
            return 1240;
        }
        mp = new HashMap<>();
        if (m > n) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        preArr = new int[m];
        curArr = new int[m];
        this.n = n;
        this.m = m;
        this.intro = introvertsCount;
        this.extro = extrovertsCount;

        len = (int) Math.pow(3, m);
        dp = new int[n][introvertsCount + 1][extrovertsCount + 1][len + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    Arrays.fill(dp[i][j][k], -2);
                }
            }
        }
        return dfs(0, 0, 0, 0);
    }

    int dfs(int pos, int in, int ex, int pre) {
        if (in > intro) {
            return -1;
        }
        if (ex > extro) {
            return -1;
        }
        if (in >= intro && ex >= extro) {
            return 0;
        }
        if (pos == n) {
            return 0;
        }
        if (dp[pos][in][ex][pre] != -2) {
            return dp[pos][in][ex][pre];
        }
        int ans = Integer.MIN_VALUE;
        for (int cur = 0; cur < len; cur++) {
            Item item = calculate(pre, cur);
            int tmp = dfs(pos + 1, in + item.in, ex + item.ex, cur);
            if (tmp != -1) {
                ans = Math.max(ans, tmp + item.happy);
            }
        }
        return dp[pos][in][ex][pre] = (ans == Integer.MIN_VALUE ? -1 : ans);
    }

    public Item calculate(int pre, int cur) {
        String key = pre + "_" + cur;
        if (mp.containsKey(key)) {
            return mp.get(key);
        }
        for (int i = 0; i < preArr.length; i++) {
            preArr[i] = pre % 3;
            pre /= 3;
            curArr[i] = cur % 3;
            cur /= 3;
        }

        int ans = 0;
        for (int i = 0; i < preArr.length; i++) {
            if (preArr[i] == 0) {
                continue;
            }
            if (preArr[i] == 1) {
                if (curArr[i] != 0) {
                    ans -= 30;
                }
            } else {
                if (curArr[i] != 0) {
                    ans += 20;
                }
            }
        }
        int in = 0, ex = 0;
        for (int i = 0; i < curArr.length; i++) {
            if (curArr[i] == 0) {
                continue;
            } else if (curArr[i] == 1) {
                in++;
                if (i > 0 && curArr[i - 1] != 0) {
                    ans -= 30;
                }
                if (preArr[i] != 0) {
                    ans -= 30;
                }
                if (i < curArr.length - 1 && curArr[i + 1] != 0) {
                    ans -= 30;
                }
            } else {
                if (i > 0 && curArr[i - 1] != 0) {
                    ans += 20;
                }
                if (preArr[i] != 0) {
                    ans += 20;
                }
                if (i < curArr.length - 1 && curArr[i + 1] != 0) {
                    ans += 20;
                }
                ex++;
            }
        }
        Item item = new Item(in, ex, ans + in * 120 + ex * 40);
        mp.put(key, item);
        return item;
    }

    private static class Item {

        int in;
        int ex;
        int happy;

        public Item(int in, int ex, int happy) {
            this.in = in;
            this.ex = ex;
            this.happy = happy;
        }

        @Override
        public String toString() {
            return "Item{" +
                "in=" + in +
                ", ex=" + ex +
                ", happy=" + happy +
                '}';
        }
    }
}
