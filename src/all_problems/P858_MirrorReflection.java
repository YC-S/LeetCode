package all_problems;

public class P858_MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int m = q, n = p;
        while (m % 2 == 0 && n % 2 == 0) {
            m /= 2;
            n /= 2;
        }
        if (m % 2 == 0 && n % 2 == 1) return 0;
        if (m % 2 == 1 && n % 2 == 1) return 1;
        if (m % 2 == 1 && n % 2 == 0) return 2;
        return -1;
    }
}
