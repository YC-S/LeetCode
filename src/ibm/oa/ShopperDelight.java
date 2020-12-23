package ibm.oa;

import java.util.Arrays;
import java.util.List;

public class ShopperDelight {
    public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int budgeted) {
        int a = priceOfJeans.size();
        int b = priceOfShoes.size();
        int c = priceOfSkirts.size();
        int d = priceOfTops.size();
        int ab = a * b;
        int[] arrAB = new int[ab];
        for (int i = 0; i < a; ++i) {
            for (int j = 0; j < b; ++j) {
                arrAB[i * b + j] = priceOfJeans.get(i) + priceOfShoes.get(j);
            }
        }
        int cd = c * d;
        int[] arrCD = new int[cd];
        for (int i = 0; i < c; ++i) {
            for (int j = 0; j < d; ++j) {
                arrCD[i * d + j] = priceOfSkirts.get(i) + priceOfTops.get(j);
            }
        }
        Arrays.sort(arrAB);
        Arrays.sort(arrCD);
        reverse(arrCD, arrCD.length);
        long sum = 0;
        int end = 0;
        for (int i = 0; i < arrAB.length; ++i) {
            int val = arrAB[i];
            int left = budgeted - val;
            while (end < arrCD.length && arrCD[end] > left) end++;
            if (end == arrCD.length) break;
            sum += (arrCD.length - end);
        }
        return sum;
    }

    private static void reverse(int[] a, int n) {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    public static void main(String[] args) {
        List<Integer> priceOfJeans = Arrays.asList(2, 3);
        List<Integer> priceOfShoes = Arrays.asList(4);
        List<Integer> priceOfSkirts = Arrays.asList(2);
        List<Integer> priceOfTops = Arrays.asList(1, 2, 3);
        int budgeted = 10;
        System.out.println(getNumberOfOptions(priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops, budgeted));
    }
}
