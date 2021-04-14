package company.others.expedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EscapePrison {
    static long prison(int n, int m, int[] h, int[] v) {
        ArrayList<ArrayList<Long>> prison = new ArrayList<ArrayList<Long>>();
        for (int r = 0; r <= n; r++) {
            ArrayList<Long> temp = new ArrayList<Long>();
            for (int c = 0; c <= m; c++) {
                temp.add((long) 1);
            }
            prison.add(temp);
        }

        int[] x = h;
        int xnum = x.length;
        Arrays.sort(x);
        int[] y = v;
        int ynum = y.length;
        Arrays.sort(y);

        //removing bar i means that list at i-1 and at i
        for (int a = xnum - 1; a >= 0; a--) {
            int i = x[a];
            for (int cell = 0; cell < prison.get(i).size(); cell++) {
                prison.get(i).set(cell, prison.get(i).get(cell) + prison.get(i - 1).get(cell));
            }
            prison.remove(i - 1);
        }


        ArrayList<ArrayList<Long>> newprison = new ArrayList<ArrayList<Long>>();

        for (int col = 0; col < prison.get(0).size(); col++) {
            ArrayList<Long> temp = new ArrayList<Long>();
            for (int row = 0; row < prison.size(); row++) {
                temp.add(prison.get(row).get(col));
            }
            newprison.add(temp);
        }

        for (int b = ynum - 1; b >= 0; b--) {
            int i = y[b];
            for (int cell = 0; cell < newprison.get(i).size(); cell++) {
                newprison.get(i).set(cell, newprison.get(i).get(cell) + newprison.get(i - 1).get(cell));
            }
            newprison.remove(i - 1);
        }

        long max = 1;
        for (ArrayList<Long> arr : newprison) {
            for (long num : arr) {
                if (num > max)
                    max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(prison(6, 6, new int[]{4}, new int[]{2}));
    }
}
