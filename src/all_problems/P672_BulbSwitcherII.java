package all_problems;

public class P672_BulbSwitcherII {
    public int flipLights(int n, int m) {
        if (m == 0) return 1;
        if (n == 1) return 2;
        if (n == 2 && m == 1) return 3;
        if (n == 2) return 4;
        if (m == 1) return 4;
        if (m == 2) return 7;
        if (m >= 3) return 8;
        return 8;
    }
}
