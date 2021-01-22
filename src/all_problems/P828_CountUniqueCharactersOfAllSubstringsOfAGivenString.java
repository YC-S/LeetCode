package all_problems;

import java.util.Arrays;

public class P828_CountUniqueCharactersOfAllSubstringsOfAGivenString {
    public int uniqueLetterString(String s) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; ++i) Arrays.fill(index[i], -1);
        int res = 0, N = s.length(), mod = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < N; ++i) {
            int c = s.charAt(i) - 'A';
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
            index[c] = new int[]{index[c][1], i};
        }
        for (int c = 0; c < 26; ++c)
            res = (res + (N - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
        return res;
    }
}
