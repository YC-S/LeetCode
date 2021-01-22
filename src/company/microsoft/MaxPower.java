package company.microsoft;

public class MaxPower {
    public int maxPower(String s) {
        char prev = s.charAt(0);
        int cur = 1;
        int max = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == prev) {
                cur++;
                max = Math.max(cur, max);
            } else {
                prev = s.charAt(i);
                cur = 1;
            }
        }
        return max;
    }
}
