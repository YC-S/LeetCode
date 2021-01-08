package book.Algorithms.chapter1.section1;

public class P1_1_19 {
    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(fibonacci(i));
        }
    }
}
