package all_problems;

public class P1714_SumOfSpecailEvenlySpacedElementsInArray {
    static int mod = 1_000_000_007;

    public int[] solve(int[] nums, int[][] queries) {
        int n = nums.length;
        int sqrtn = (int) Math.sqrt(n) + 1;
        int[][] map = new int[sqrtn][n];
        for (int i = 1; i * i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) map[i][n - j - 1] = nums[n - j - 1];
                else map[i][n - j - 1] = ((map[i][n - j - 1 + i] + nums[n - j - 1]) % mod);
            }
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (y * 1l * y <= n) {
                res[i] = map[y][x];
            } else {
                for (int j = x; j < n; j += y) res[i] = (res[i] + nums[j]) % mod;
            }
        }
        return res;
    }
}
