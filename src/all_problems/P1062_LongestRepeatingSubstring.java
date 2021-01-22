package all_problems;

import java.util.HashSet;
import java.util.Set;

public class P1062_LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String S) {
        char[] cs = S.toCharArray();
        int s = 1, e = cs.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (search(cs, mid)) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return s - 1;
    }

    boolean search(char[] cs, int k) {
        Set<Integer> s = new HashSet<>();
        long mod = 10000000007L, pow = 1, cur = 0;
        for (int i = 0; i < cs.length; i++) {
            cur = (cur * 26 + (cs[i] - 'a')) % mod;
            if (i >= k) {
                cur = (cur - ((cs[i - k] - 'a') * pow % mod) + mod) % mod;
            } else {
                pow = pow * 26 % mod;
            }
            if (i >= k - 1) {
                if (!s.add((int) cur)) return true;
            }
        }
        return false;
    }
}
