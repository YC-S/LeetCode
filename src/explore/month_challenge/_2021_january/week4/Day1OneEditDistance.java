package explore.month_challenge._2021_january.week4;

public class Day1OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int ns = s.length();
        int nt = t.length();

        if (nt < ns) {
            return isOneEditDistance(t, s);
        }

        if (nt - ns > 1) return false;

        for (int i = 0; i < ns; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (ns == nt) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        return (ns + 1 == nt);
    }
}
