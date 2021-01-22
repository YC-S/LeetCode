package all_problems;

public class P1055_ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        int t = 0;
        int ans = 0;
        while (t < target.length()) {
            int pt = t;

            for (int s = 0; s < source.length(); s++) {
                if (t < target.length() && source.charAt(s) == target.charAt(t)) {
                    t++;
                }
            }

            if (t == pt) {
                return -1;
            }
            ans++;
        }

        return ans;
    }
}
