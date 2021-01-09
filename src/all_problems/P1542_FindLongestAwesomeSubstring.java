package all_problems;

import java.util.Arrays;

public class P1542_FindLongestAwesomeSubstring {
    public int longestAwesome(String s) {
        int res = 0;
        int cur = 0;
        int n = s.length();
        int[] seen = new int[1024];
        Arrays.fill(seen, n);
        seen[0] = -1;
        for (int i = 0; i < n; ++i) {
            cur ^= 1 << (s.charAt(i) - '0');
            for (int a = 0; a < 10; ++a)
                res = Math.max(res, i - seen[cur ^ (1 << a)]);
            res = Math.max(res, i - seen[cur]);
            seen[cur] = Math.min(seen[cur], i);
        }
        return res;
    }
}
