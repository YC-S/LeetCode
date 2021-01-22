package all_problems;

public class P878_NthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        long aa = a, bb = b, tmp, l = 2, r = (long) 1e14, mod = (long) 1e9 + 7;
        while (bb > 0) {
            tmp = aa;
            aa = bb;
            bb = tmp % bb;
        }
        while (l < r) {
            long m = (l + r) / 2;
            if (m / a + m / b - m / (a * b / aa) < n) l = m + 1;
            else r = m;
        }
        return (int) (l % mod);
    }
}
