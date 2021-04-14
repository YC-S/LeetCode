package company.others.expedia;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EscapePrison {
    static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        boolean[] xs = new boolean[n + 1];
        boolean[] ys = new boolean[m + 1];
        for (Integer i : h) xs[i] = true;
        for (Integer i : v) ys[i] = true;
        int xm = 0, ym = 0;
        for (int i = 1, j = 0; i <= n; i++) {
            if (!xs[i]) j = 0;
            else xm = Math.max(xm, ++j);
        }
        for (int i = 1, j = 0; i <= m; i++) {
            if (!ys[i]) j = 0;
            else ym = Math.max(ym, ++j);
        }
        return (long) (xm + 1) * (ym + 1);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(prison(6, 6, Arrays.asList(4), Arrays.asList(2)));
    }
}
