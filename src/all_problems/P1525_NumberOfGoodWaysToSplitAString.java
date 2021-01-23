package all_problems;

public class P1525_NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        int[] rc = new int[26];
        int[] lc = new int[26];
        int l = 0;
        int r = 0;
        int res = 0;
        for (char c : s.toCharArray()) if (rc[c - 'a']++ == 0) r++;
        for (char c : s.toCharArray()) {
            if (lc[c - 'a']++ == 0) l++;
            if (--rc[c - 'a'] == 0) r--;
            if (l == r) res++;
        }
        return res;
    }
}
