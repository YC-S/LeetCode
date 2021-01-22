package all_problems;

import java.util.Arrays;

public class P940_DistinctSubsequencesII {
    public int distinctSubseqII(String S) {
        long[] end = new long[26];
        long mod = (long) 1e9 + 7;
        for (char c : S.toCharArray())
            end[c - 'a'] = Arrays.stream(end).sum() % mod + 1;
        return (int) (Arrays.stream(end).sum() % mod);
    }
}
