package all_problems;

public class P1147_LongestChunkedPalindromeDecomposition {
    public int longestDecomposition(String text) {
        int res = 0, n = text.length();
        String l = "", r = "";
        for (int i = 0; i < n; ++i) {
            l = l + text.charAt(i);
            r = text.charAt(n - i - 1) + r;
            if (l.equals(r)) {
                ++res;
                l = "";
                r = "";
            }
        }
        return res;
    }
}
