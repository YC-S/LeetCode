package 牛客网.华为面试.第二轮;

public class Q4 {
    // string >> maximum substring
    public int solve(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return 0;
        }
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        /*
            遍历两个字符串:
                1、若 当前两个字符 相等：
                    当前状态 = 两个元素的前一个状态 + 1
                2、若 当前两个字符 不等：
                    当前状态 = 两个元素任一元素的前一个状态 的 最大值
         */
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        dp[0][0] = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
