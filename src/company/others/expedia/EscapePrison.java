package company.others.expedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EscapePrison {
    static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        ArrayList<ArrayList<Long>> prison = new ArrayList<ArrayList<Long>>();
        for (int r = 0; r <= n; r++) {
            ArrayList<Long> temp = new ArrayList<Long>();
            for (int c = 0; c <= m; c++) {
                temp.add((long) 1);
            }
            prison.add(temp);
        }

        List<Integer> x = h;
        int xnum = x.size();
        Collections.sort(x);
        List<Integer> y = v;
        int ynum = y.size();
        Collections.sort(y);

        //removing bar i means that list at i-1 and at i
        for (int a = xnum - 1; a >= 0; a--) {
            int i = x.get(a);
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
            int i = y.get(b);
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
        System.out.println(prison(6, 6, Arrays.asList(4), Arrays.asList(2)));
    }
}
